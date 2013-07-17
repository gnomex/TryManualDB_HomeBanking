package br.unioeste.trymanualDB.model.factory;

import java.util.List;

import br.unioeste.base.BankAccount;
import br.unioeste.base.Client;

public interface FactoryDAOAccount {

	//Add new account and returns the account with account id
	public BankAccount createAccount(BankAccount account) throws Exception;
	
	//Search Account 
	public BankAccount retrieveAccount(BankAccount account) throws Exception;
	//Get all acounts with a customer
	public  List<BankAccount> getAllbyClient(Client client) throws Exception;
	
	//Get all accounts of database
	public  List<BankAccount> getAllAccount() throws Exception;
	
	//Alter a account
	public  void updateAccount(String column,String newValue,String oldValue) throws Exception;
	
	//Delete account from database
	public  void deleteAccount(BankAccount account) throws Exception;
	
}
