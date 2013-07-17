package br.unioeste.trymanualDB.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static br.unioeste.trymanualDB.config.DatabaseDefinitions.DriverName;

public class DatabaseConnection {

	protected Connection connection;
	protected ResultSet table;
	
	public DatabaseConnection() throws Exception	{
		//Load de JDBC driver
		Class.forName(DriverName);
	}
	

	public void connect(DatabaseUserAuthentication userAuth) throws Exception{
		
		StringBuffer paramToConnect = new StringBuffer();
		//Append url
		paramToConnect.append("jdbc:mysql://localhost/" + userAuth.getBd() + "?");
		//Append user
		paramToConnect.append("user=" + userAuth.getUsuario());
		//Append password
		paramToConnect.append("&password=" + userAuth.getSenha());
		
		connection = DriverManager.getConnection(paramToConnect.toString());
		
		System.out.println(connection);
		
		connection.setAutoCommit(true);
		
	}

	public void close()throws Exception{
		connection.close();
	}

	/**
	 * executa determinado  código sql e retorna um resultset
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet executeSQL(StringBuffer sql) throws Exception{
		Statement s = connection.createStatement();
		ResultSet result = s.executeQuery(sql.toString());
		return result;
	}
	public void execute(StringBuffer sql)	throws Exception{
		Statement s = connection.createStatement();
		s.execute(sql.toString());
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
