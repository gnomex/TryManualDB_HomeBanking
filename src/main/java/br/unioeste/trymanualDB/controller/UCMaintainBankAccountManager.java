package br.unioeste.trymanualDB.controller;

import java.util.List;

import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;
import br.unioeste.trymanualDB.model.EntityManager;


public class UCMaintainBankAccountManager {

	private EntityManager entityManager = new EntityManager();
	
	public BankAccount insertAccount(BankAccount account , String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		
		return entityManager.getAccountFactory(which).createAccount(account);
		
	}
	
	public BankAccount findAccount(BankAccount account, String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory(which).retrieveAccount(account);
	}
	
	public List<BankAccount> getAllAccounts(String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory(which).getAllAccount();
	}
	
	public List<BankAccount> getAllAccountsByClient(Client client, String which) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception	{
		return entityManager.getAccountFactory(which).getAllbyClient(client);
	}
}
