package br.unioeste.trymanualDB.model.factory;

import java.util.List;

import br.unioeste.base.Client;

public interface FactoryDAOClient {

	//Add new client and returns the client with account id
	public Client createClient(Client client) throws Exception;
	
	//Search Client
	public Client retrieveClientFromName(Client client) throws Exception;
	public Client retrieveClientFromid(Client client) throws Exception;
	
	//Get all clients of database
	public List<Client> getAllClients() throws Exception;
	
	//Alter client
	public  void updateClient(String column,String newValue,String oldValue) throws Exception;
	
	//Delete client from database
	public  void deleteClient(Client client) throws Exception;
	
	public List<String> retrieveAllTypeClient() throws Exception;
}
