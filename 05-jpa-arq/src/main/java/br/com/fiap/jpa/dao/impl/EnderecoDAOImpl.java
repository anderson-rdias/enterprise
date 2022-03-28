package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Endereco;
import br.com.fiap.jpa.dao.HibernateGenericDAO;

public class EnderecoDAOImpl extends HibernateGenericDAO<Endereco, Long>{
	
	private static EnderecoDAOImpl instance;

	public EnderecoDAOImpl() {
		super(Endereco.class);
		// TODO Auto-generated constructor stub
	}
	
	public static EnderecoDAOImpl getInstance() {
		if (instance == null) {
			instance = new EnderecoDAOImpl();
		}
		
		return instance;
	}

}
