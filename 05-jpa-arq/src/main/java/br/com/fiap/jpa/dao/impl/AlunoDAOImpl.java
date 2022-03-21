package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Aluno;
import br.com.fiap.jpa.dao.HibernateGenericDAO;

public class AlunoDAOImpl extends HibernateGenericDAO<Aluno, Long>{
	
	private static AlunoDAOImpl instance;

	public AlunoDAOImpl() {
		super(Aluno.class);
		// TODO Auto-generated constructor stub
	}
	
	public static AlunoDAOImpl getInstance() {
		if (instance == null) {
			instance = new AlunoDAOImpl();
		}
		
		return instance;
	}

}
