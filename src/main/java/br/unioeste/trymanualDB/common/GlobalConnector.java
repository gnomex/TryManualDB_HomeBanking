package br.unioeste.trymanualDB.common;

import static br.unioeste.trymanualDB.config.DatabaseDefinitions.SchemeModelName;

public class GlobalConnector {

	
	/**
	 * Returns a BD connection
	 * 
	 * */
	public static DatabaseConnection getConnection() throws Exception	{

		DatabaseUserAuthentication userAuth = new DatabaseUserAuthentication();
		userAuth.setBd(SchemeModelName);
		userAuth.setUser("root");
		userAuth.setPasswd("");

		DatabaseConnection db_connection = new DatabaseConnection();
		db_connection.connect(userAuth);

		return db_connection;

	}

}
