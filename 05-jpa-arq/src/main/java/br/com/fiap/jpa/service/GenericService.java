package br.com.fiap.jpa.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.PersistenceManager;

public abstract class GenericService<T extends Serializable, PK extends Serializable> {
	
	private EntityManager entityManager;
	
	public abstract void inserir(T instancia);
	public abstract void atualizar(T instancia);
	public abstract void remover(PK id);
	public abstract T obter (PK id);
	public abstract List<T> listar();
	
	public EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
		}
		
		return entityManager;
	}
	
	public void closeEntityManager() {
		if (entityManager != null) {
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

}
