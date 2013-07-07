package br.unioeste.base;

import java.sql.Date;


public class Client{

	//private Person client;

	private int idClient;

	private String name;
	private String cpf;
	private String rg;
	//private CNPJ cnpj;
	private Date bithDate;



	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getBirthDate() {
		return bithDate;
	}
	public void setBirthDate(Date dataNacsimento) {
		this.bithDate = dataNacsimento;
	}



}
