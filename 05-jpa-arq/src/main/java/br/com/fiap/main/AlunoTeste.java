package br.com.fiap.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Endereco;
import br.com.fiap.jpa.dao.PersistenceManager;
import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.service.impl.AlunoServiceImpl;

public class AlunoTeste {
	
	public static void main(String[] args) {
		
		AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();
		
		Aluno aluno3 = new Aluno ("Aluno 3", "33333", "333.333.333-33", LocalDate.of(1980, 1, 1));
		
		alunoService.inserir(new Aluno("Aluno 1", "11111", "111.111.111-11", LocalDate.of(2000, 1, 1)));
		alunoService.inserir(new Aluno("Aluno 2", "22222", "222.222.222-22", LocalDate.of(1990, 1, 1)));
		
		Endereco endereco = new Endereco("Av. Paulista", 777, "5 andar",
				"Bela Vista", "São Paulo", "SP", "04566-333");
		
		alunoService.inserirComEndereco(aluno3, endereco);
		
		Aluno aluno = alunoService.obter(3L);
		System.out.println(aluno);
		
		alunoService.remover(3L);
		
	}

}
