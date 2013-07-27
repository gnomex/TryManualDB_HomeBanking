package br.unioeste.trymanualDB.controller;

import java.util.List;

import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.trymanualDB.model.EntityManager;


public class UCMaintainBankAccountManager {

	private EntityManager entityManager = new EntityManager();
	
	public BankAccount insertAccount(BankAccount account) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getAccountFactory().createAccount(account);
		
	}
	
	public BankAccount findAccount(BankAccount account) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory().retrieveAccount(account);
	}
	
	public List<BankAccount> getAllAccounts() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory().getAllAccount();
	}
	
	public List<BankAccount> getAllAccountsByClient(Client client) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory().getAllbyClient(client);
	}
	
	public List<String> getAllTypeAccounts() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception{
		return entityManager.getAccountFactory().retrieveAllTypeAccount();
	}
}
