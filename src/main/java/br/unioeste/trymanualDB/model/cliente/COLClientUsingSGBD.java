package br.unioeste.trymanualDB.model.cliente;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.trymanualDB.common.DatabaseConnection;
import br.unioeste.trymanualDB.common.GlobalConnector;
import br.unioeste.base.Client;
import br.unioeste.base.TipoCliente;
import br.unioeste.trymanualDB.model.factory.FactoryDAOClient;

public class COLClientUsingSGBD implements FactoryDAOClient{
	
	private DatabaseConnection connection = null;	//GlobalConnector.getInstance();

	public Client createClient(Client client) throws Exception {
		SimpleDateFormat dtForm = new SimpleDateFormat("yyyy-MM-dd");

		connection = GlobalConnector.getConnection();

		StringBuffer sql = new StringBuffer("INSERT INTO Cliente(Nome, Sobrenome, CPF, RG, CNPJ, Email, DataNascimento, UserName, Userpasswd, Tipocliente_id)");

		sql.append(" VALUES('" + client.getName() + "','");
		
		sql.append(client.getLastName() + "','");

		sql.append(client.getCpf() + "','");

		sql.append(client.getRg() + "','");
		
		sql.append(client.getCNPJ() + "','");
		
		sql.append(client.getEmail() + "','");

		sql.append(dtForm.format(client.getBirthDate()) + "','");
		
		sql.append(client.getUserName() + "','");
		
		sql.append(client.getPwd() + "',");
		
		sql.append(client.getTipo().getId() + ");");

		connection.execute(sql);

		connection.close();

		client.setIdClient(this.retriveLastIndex());
		return client;
	}

	private int retriveLastIndex() throws Exception	{

		connection = GlobalConnector.getConnection();		
		//SELECT MAX(ID) FROM Client
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

	public Client retrieveClientFromName(Client client) throws Exception {
		connection = GlobalConnector.getConnection();

		//SELECT * FROM Cliente WHERE Nome=
		StringBuffer sql = new StringBuffer("SELECT * FROM cliente WHERE Nome = \'"+client.getName()+"\'");

		ResultSet rs = connection.executeSQL(sql);

		if(rs != null){
			while(rs.next())	{
				client.setIdClient(rs.getInt(1));
				client.setLastName(rs.getString(3));
				client.setCpf(rs.getString(4));
				client.setRg(rs.getString(5));
				client.setCNPJ(rs.getString(6));
				client.setEmail(rs.getString(7));
				client.setBirthDate(rs.getDate(8));
				client.setUserName(rs.getString(9));
				client.setPwd(rs.getString(10));
				TipoCliente tipo = new TipoCliente();
				tipo.setId(rs.getInt(11));
				client.setTipo(tipo);
			}
		}
		else client = null;

		connection.close();

		return client;
	}
	
	public List<String> retrieveAllTypeClient() throws Exception{
		List list = null;
		connection = GlobalConnector.getConnection();
		
		StringBuffer sql = new StringBuffer("SELECT nome FROM tipocliente");
		
		ResultSet rs = connection.executeSQL(sql);
		
		if(rs != null){
			list = new ArrayList<String>();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}
		return list;
	}

	public Client retrieveClientFromid(Client client) throws Exception {
		connection = GlobalConnector.getConnection();

		//SELECT * FROM Cliente WHERE id=
		StringBuffer sql = new StringBuffer("SELECT * FROM Client WHERE");

		sql.append("id=" + client.getIdClient() + ";");

		ResultSet rs = connection.executeSQL(sql);

		while(rs.next())	{
			client.setName(rs.getString(2));;
			client.setLastName(rs.getString(3));
			client.setCpf(rs.getString(4));
			client.setRg(rs.getString(5));
			client.setCNPJ(rs.getString(6));
			client.setEmail(rs.getString(7));
			client.setBirthDate(rs.getDate(8));
			client.setUserName(rs.getString(9));
			client.setPwd(rs.getString(10));
		}

		connection.close();

		return client;
	}

	public List<Client> getAllClients() throws Exception {
		connection = GlobalConnector.getConnection();

		StringBuffer sql = new StringBuffer("SELECT * FROM Cliente");

		ResultSet rs = connection.executeSQL(sql);

		List<Client> clients = new ArrayList<Client>();

		
		while(rs.next())	{
			Client client = new Client();

			client.setIdClient(rs.getInt(1));
			client.setName(rs.getString(2));;
			client.setLastName(rs.getString(3));
			client.setCpf(rs.getString(4));
			client.setRg(rs.getString(5));
			client.setCNPJ(rs.getString(6));
			client.setEmail(rs.getString(7));
			client.setBirthDate(rs.getDate(8));
			client.setUserName(rs.getString(9));
			client.setPwd(rs.getString(10));
			//Add customer to list
			
			clients.add(client);			
		}

		connection.close();

		System.out.println(clients.size());
		
		return clients;
	}

	public void updateClient(String column,String newValue,String oldValue) throws Exception {
		connection = GlobalConnector.getConnection();
		
		StringBuffer build = new StringBuffer(); 
		build.append("UPDATE cliente SET " + column + "='" + newValue + "' WHERE " + column + "='" + oldValue + "';");
		
		connection.executeUpdate(build);
		
		connection.close();
	}

	public Client deleteClient(Client client) throws Exception {
		client = retrieveClientFromName(client);
		
		if(client == null){ //cliente não cadastrado
			client = new Client();
			client.setIdClient(-1);
			return client;
		}
		
		connection = GlobalConnector.getConnection();
		
		StringBuffer build = new StringBuffer();
		build.append("DELETE FROM cliente WHERE id = "+client.getIdClient());
		
		connection.executeUpdate(build);;
		connection.close();
		
		return null;
	}

}
