package br.unioeste.trymanualDB.model;

import br.unioeste.trymanualDB.model.cliente.COLClientUsingSGBD;
import br.unioeste.trymanualDB.model.conta.COLAccontUsingSGBD;
import br.unioeste.trymanualDB.model.factory.FactoryDAOAccount;
import br.unioeste.trymanualDB.model.factory.FactoryDAOClient;



/**
 * Management of databases to use, text file or mysql SGBD database
 * */

public class EntityManager {

	public FactoryDAOAccount getAccountFactory()
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		return new COLAccontUsingSGBD();
	}

	public FactoryDAOClient getClientFactory()
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {		
		return new COLClientUsingSGBD();
	}

}
