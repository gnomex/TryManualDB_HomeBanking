package br.unioeste.trymanualDB.common;

import java.io.Serializable;

public class DatabaseUserAuthentication implements Serializable {

	public final static long serialVersionUID = 1;


	private String passwd;
	private String user;
	private String bd;
	
	public String getSenha() { 
		return passwd; 
	}
	public String getUsuario() { 
		return user; 
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}
	
}