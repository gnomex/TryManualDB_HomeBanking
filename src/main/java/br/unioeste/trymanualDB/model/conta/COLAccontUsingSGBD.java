package br.unioeste.trymanualDB.model.conta;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.trymanualDB.common.DatabaseConnection;
import br.unioeste.trymanualDB.common.GlobalConnector;
import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.base.TipoConta;
import br.unioeste.trymanualDB.model.factory.FactoryDAOAccount;

public class COLAccontUsingSGBD implements FactoryDAOAccount{

	private DatabaseConnection connection = null;
	
	public BankAccount createAccount(BankAccount account) throws Exception {
		SimpleDateFormat dtForm = new SimpleDateFormat("yyyy-MM-dd");

		connection = GlobalConnector.getConnection();

		StringBuffer sql = new StringBuffer("INSERT INTO conta (Numero, Agencia, DataAdesao, DataEncerramento, ValorCorrenteTotalEmConta, Cliente_id, TipoConta_id)");

		sql.append(" VALUES(" + account.getAccountNumber() + ",'");
		
		sql.append(account.getBankBranch() + "','");

		sql.append(dtForm.format(account.getStartAccountDate()) + "','");

		sql.append(dtForm.format(account.getClosingAccountDate()) + "','");
		
		sql.append(account.getSaldoCorrente().toString() + "','");

		sql.append(account.getClient().getIdClient() + "',");
		
		sql.append(account.getTipo().getId() + ");");

		connection.execute(sql);

		connection.close();

		//Retrieve a Last Account with id

		try{
		
			account.setAccountNumber(this.retrieveLastIndex());
			
		}catch (Exception e){
			
			e.printStackTrace();
		}

		return account;
	}

	private int retrieveLastIndex() throws Exception	{

		connection = GlobalConnector.getConnection();		

		StringBuffer sql = new StringBuffer("SELECT LAST_INSERT_ID()");

		ResultSet rs = connection.executeSQL(sql);

		/**
		 * @DANGEROUS 
		 * 
		 * */
		int lastid = 0;

		while(rs.next())	{
			lastid = rs.getInt(1);
		}

		connection.close();

		return lastid;

	}
	
	public List<String> retrieveAllTypeAccount() throws Exception{
		List list = null;
		connection = GlobalConnector.getConnection();
		
		StringBuffer sql = new StringBuffer("SELECT nome FROM tipoconta");
		
		ResultSet rs = connection.executeSQL(sql);
		
		if(rs != null){
			list = new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}
		return list;
	}
	
	public BankAccount retrieveAccount(BankAccount account) throws Exception {
		connection = GlobalConnector.getConnection();

		// SELECT * FROM `Conta` WHERE 1
		StringBuffer sql = new StringBuffer("SELECT * FROM conta WHERE Cliente_id = "+account.getClient().getIdClient());

		ResultSet rs = connection.executeSQL(sql);

		while(rs.next())	{
			account.setAccountNumber(rs.getInt(1));
			account.setBankBranch(rs.getString(2));
			account.setStartAccountDate(rs.getDate(3));
			account.setClosingAccountDate(rs.getDate(4));
			account.setSaldoCorrente(rs.getFloat(5));
			TipoConta tipo = new TipoConta();
			tipo.setId(rs.getInt(7));
			account.setTipo(tipo);
		}

		connection.close();
		
		return account;
	}

	public List<BankAccount> getAllbyClient(Client client) throws Exception {
		connection = GlobalConnector.getConnection();

		// SELECT * FROM `Conta` WHERE 1
		StringBuffer sql = new StringBuffer("SELECT * Conta WHERE");

		sql.append("Cliente_id=" + client.getIdClient() + ";");

		ResultSet rs = connection.executeSQL(sql);

		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		while(rs.next())	{
			BankAccount account = new BankAccount();
			account.setAccountNumber(rs.getInt(1));
			account.setBankBranch(rs.getString(2));

			account.setStartAccountDate(rs.getDate(3));

			account.setClosingAccountDate(rs.getDate(4));
			
			account.setSaldoCorrente(rs.getFloat(5));

			accounts.add(account);

		}

		connection.close();
		
		return accounts;
	}

	public List<BankAccount> getAllAccount() throws Exception {
		connection = GlobalConnector.getConnection();

		// SELECT * FROM `Conta` WHERE 1
		StringBuffer sql = new StringBuffer("SELECT * FROM Conta");

		ResultSet rs = connection.executeSQL(sql);

		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		while(rs.next())	{
			
			BankAccount account = new BankAccount();
			
			account.setAccountNumber(rs.getInt(1));
			account.setBankBranch(rs.getString(2));

			account.setStartAccountDate(rs.getDate(3));

			account.setClosingAccountDate(rs.getDate(4));
			
			account.setSaldoCorrente(rs.getFloat(5));
			
			Client client = new Client();
			client.setIdClient(rs.getInt(6));
			account.setClient(client);

			accounts.add(account);

		}

		connection.close();
		
		return accounts;
	}

	public void updateAccount(String column, String newValue, String oldValue)
			throws Exception {
		connection = GlobalConnector.getConnection();
		
		StringBuffer build = new StringBuffer(); 
		build.append("UPDATE Conta SET " + column + "='" + newValue + "' WHERE " + column + "='" + oldValue + "';");
		
		connection.executeUpdate(build);;
		
		connection.close();
	}

	public BankAccount deleteAccount(BankAccount account) throws Exception {
		account = retrieveAccount(account);
		
		if(account == null){ //se não existe a conta
			account = new BankAccount();
			account.setAccountNumber(-1);
			return account;
		}
		
		connection = GlobalConnector.getConnection();
		
		StringBuffer build = new StringBuffer();
		build.append("DELETE FROM conta WHERE Cliente_id = "+account.getClient().getIdClient());
		
		connection.executeUpdate(build);
		connection.close();
		
		return null;
	}

}
