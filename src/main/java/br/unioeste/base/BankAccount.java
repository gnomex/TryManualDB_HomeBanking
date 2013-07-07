package br.unioeste.base;

import java.sql.Date;

public class BankAccount {

	private Client client;
	
	private int accountNumber;
	private String bankBranch;
	private Date startAccountDate;
	private Date closingAccountDate;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public Date getStartAccountDate() {
		return startAccountDate;
	}
	public void setStartAccountDate(Date startAccountDate) {
		this.startAccountDate = startAccountDate;
	}
	public Date getClosingAccountDate() {
		return closingAccountDate;
	}
	public void setClosingAccountDate(Date closingAccountDate) {
		this.closingAccountDate = closingAccountDate;
	}
	
	
	
}