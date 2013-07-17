package br.unioeste.trymanualDB.model.conta;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.trymanualDB.common.DatabaseConnection;
import br.unioeste.trymanualDB.common.GlobalConnector;
import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.trymanualDB.model.factory.FactoryDAOAccount;

public class COLAccontUsingSGBD implements FactoryDAOAccount{

	private DatabaseConnection connection = null;
	
	public BankAccount createAccount(BankAccount account) throws Exception {
		SimpleDateFormat dtForm = new SimpleDateFormat("yyyy-MM-dd");

		connection = GlobalConnector.getConnection();

		StringBuffer sql = new StringBuffer("INSERT INTO Conta(Agencia, DataAdesao, DataEncerramento, ValorCorrenteTotalEmConta, Cliente_id)");

		sql.append(" VALUES('" + account.getBankBranch() + "','");

		sql.append(dtForm.format(account.getStartAccountDate().toString()) + "','");

		sql.append(dtForm.format(account.getClosingAccountDate().toString()) + "','");
		
		sql.append(account.getSaldoCorrente() + "','");

		sql.append(account.getClient().getIdClient() + "');");

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
	
	public BankAccount retrieveAccount(BankAccount account) throws Exception {
		connection = GlobalConnector.getConnection();

		// SELECT * FROM `Conta` WHERE 1
		StringBuffer sql = new StringBuffer("SELECT * Conta Cliente WHERE");

		sql.append("Numero=" + account.getAccountNumber() + ";");

		ResultSet rs = connection.executeSQL(sql);

		while(rs.next())	{
			account.setBankBranch(rs.getString(2));

			Client client = new Client();
			client.setIdClient(rs.getInt(6));
			account.setClient(client);

			account.setStartAccountDate(rs.getDate(3));

			account.setClosingAccountDate(rs.getDate(4));
			
			account.setSaldoCorrente(rs.getFloat(5));

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
		
		connection.execute(build);
		
		connection.close();
	}

	public void deleteAccount(BankAccount account) throws Exception {
		connection = GlobalConnector.getConnection();
		
		StringBuffer build = new StringBuffer();
		build.append("DELETE FROM Conta WHERE Cliente_id =");
		build.append(account.getClient() + ";");
		
		connection.execute(build);
		connection.close();
		
	}

}
