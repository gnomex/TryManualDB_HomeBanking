package br.unioeste.trymanualDB.controller;

import java.util.List;

import br.unioeste.base.Client;
import br.unioeste.trymanualDB.model.EntityManager;


public class UCMaintainCustomerManager {
	
	private EntityManager entityManager = new EntityManager();
	
	public Client insertClient(Client customer, String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getClientFactory(which).createClient(customer);
	}
	
	public Client findClientById(Client customer, String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getClientFactory(which).retrieveClientFromid(customer);
	}
	public Client findClientByName(Client customer, String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getClientFactory(which).retrieveClientFromName(customer);
	}
	
	public List<Client> getAllClients(String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getClientFactory(which).getAllClients();
	}

}
