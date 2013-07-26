package br.unioeste.base;

import java.sql.Date;


public class Client{

	//private Person client;

	private int idClient;

	private String name;
	private String lastName;
	private String cpf;
	private String rg;
	private String cnpj;
	private Date bithDate;
	private String email;
	private String userName;
	private String pwd;
	private TipoCliente tipo;
	
	public Client(){
		
	}
	
	public Client(int idClient, String name, String lastName, String cpf,
			String rg, String cnpj, Date bithDate, String email,
			String userName, String pwd) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		this.rg = rg;
		this.cnpj = cnpj;
		this.bithDate = bithDate;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
	}
	
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

	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}

	public void setCNPJ(String cnpj){
		this.cnpj = cnpj;
	}
	
	public String getCNPJ(){
		return cnpj;
	}
	
	public void setLastName(String last){
		this.lastName = last;
	}
	
	public String getLastName(){
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	
}
