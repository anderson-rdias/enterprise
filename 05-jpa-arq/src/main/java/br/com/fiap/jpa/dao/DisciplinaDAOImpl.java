package br.com.fiap.jpa.dao;

import br.com.fiap.entity.Disciplina;

public class DisciplinaDAOImpl extends HibernateGenericDAO<Disciplina, Long>{
	
	private static DisciplinaDAOImpl instance;

	public DisciplinaDAOImpl() {
		super(Disciplina.class);
		// TODO Auto-generated constructor stub
	}
	
	public static DisciplinaDAOImpl getInstance() {
		if (instance == null) {
			instance = new DisciplinaDAOImpl();
		}
		
		return instance;
	}

}
