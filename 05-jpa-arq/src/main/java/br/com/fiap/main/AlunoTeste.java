package br.com.fiap.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fiap.entity.Aluno;

public class AlunoTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ALUNO_ORACLE");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		
		//Insert
//		Aluno aluno = new Aluno();
//		aluno.setNome("Anderson");
//		aluno.setMatricula("88008");
//		aluno.setCpf("47053919854");
//		aluno.setDataNascimento(LocalDate.of(2000, 9, 24));
//		aluno.setAtivo(true);
//		aluno.setDataCadastro(LocalDateTime.now());
//		aluno.setDataAtualizacao(LocalDateTime.now());
//		entityManager.persist(aluno);
//		
//		Aluno aluno2 = new Aluno();
//		aluno2.setNome("Otavio");
//		aluno2.setMatricula("87569");
//		aluno2.setCpf("12345678912");
//		aluno2.setDataNascimento(LocalDate.of(2001, 8, 03));
//		aluno2.setAtivo(true);
//		aluno2.setDataCadastro(LocalDateTime.now());
//		aluno2.setDataAtualizacao(LocalDateTime.now());
//		entityManager.persist(aluno2);
//		
//		Aluno aluno3 = new Aluno();
//		aluno3.setNome("William");
//		aluno3.setMatricula("80593");
//		aluno3.setCpf("98765432178");
//		aluno3.setDataNascimento(LocalDate.of(1999, 10, 13));
//		aluno3.setAtivo(true);
//		aluno3.setDataCadastro(LocalDateTime.now());
//		aluno3.setDataAtualizacao(LocalDateTime.now());
//		entityManager.persist(aluno3);
		
		//SELECT * FROM TB_ALUNO
		Query query = entityManager.createQuery("SELECT a from Aluno a");
		List<Aluno> resultado = query.getResultList();
		
		resultado.forEach(System.out::println);
		
		resultado.forEach(a -> {
			System.out.println(a);
		});
		
		for (Aluno a : resultado) {
			System.out.println(a);
		}
		
		//Aluno aluno = entityManager.find(Aluno.class, 1L);
		
//		System.out.println(aluno);
		
		//Update
//		aluno.setNome("Anderson Dias");
//		aluno.setCpf("470.539.198-54");
//		aluno.setMatricula("RM88008");
//		
//		System.out.println(aluno);
		
		//Delete
//		entityManager.remove(aluno);
		
//		if (entityManager.find(Aluno.class, 1L) == null) {
//			System.out.println("Aluno Excluído");
//		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	

}
