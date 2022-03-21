package br.com.fiap.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
	private static PersistenceManager instance = null;
	
	private PersistenceManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ALUNO_ORACLE");
	}
	
	private EntityManagerFactory entityManagerFactory = null;

	public static PersistenceManager getInstance() {
		if(instance == null) {
			instance = new PersistenceManager();
		}
		
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
