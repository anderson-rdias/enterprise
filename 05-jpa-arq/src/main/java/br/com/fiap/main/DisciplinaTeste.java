package br.com.fiap.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.Disciplina;
import br.com.fiap.jpa.dao.DisciplinaDAOImpl;
import br.com.fiap.jpa.dao.PersistenceManager;

public class DisciplinaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		DisciplinaDAOImpl dao = DisciplinaDAOImpl.getInstance();
		
		entityManager.getTransaction().begin();
		
		//Insert
		Disciplina disciplina1 = new Disciplina("Matemática", 100);
		Disciplina disciplina2 = new Disciplina("Português", 120);
		Disciplina disciplina3 = new Disciplina("Inglês", 50);
		
		dao.inserir(disciplina1, entityManager);
		dao.inserir(disciplina2, entityManager);
		dao.inserir(disciplina3, entityManager);
		
		Disciplina disciplina = dao.obterPorId(3L, entityManager);
		
		List<Disciplina> resultado = dao.listar(entityManager);
		
		Disciplina maisNovo = null;
		
		for (Disciplina disciplinaDB : resultado) {
			System.out.println(disciplina);
			
			if (maisNovo == null || disciplinaDB.getDataCriacao().isBefore(maisNovo.getDataCriacao())) {
				maisNovo = disciplinaDB;
			}
		}
		
		if (maisNovo != null) {
			System.out.println("\nDisciplina mais nova:\n" + maisNovo);
			dao.remover(maisNovo.getId(), entityManager);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
