package br.unioeste.trymanualDB.controller;

import java.util.List;

import br.unioeste.base.Client;
import br.unioeste.trymanualDB.model.EntityManager;


public class UCMaintainCustomerManager {
	
	private EntityManager entityManager = new EntityManager();
	
	public Client insertClient(Client customer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getClientFactory().createClient(customer);
	}
	
	public Client findClientById(Client customer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getClientFactory().retrieveClientFromid(customer);
	}
	public Client findClientByName(Client customer) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getClientFactory().retrieveClientFromName(customer);
	}
	
	public List<Client> getAllClients() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getClientFactory().getAllClients();
	}

	public List<String> getAllTypeClients() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception{
		return entityManager.getClientFactory().retrieveAllTypeClient();
	}
}
