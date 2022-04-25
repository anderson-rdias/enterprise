package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Disciplina;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Matricula;
import br.com.fiap.jpa.service.impl.AlunoServiceImpl;
import br.com.fiap.jpa.service.impl.CursoServiceImpl;
import br.com.fiap.jpa.service.impl.DisciplinaServiceImpl;
import br.com.fiap.jpa.service.impl.MatriculaServiceImpl;

public class App {

	public static void main(String[] args) {
		
		//Instanciando service para executar operações na entidade Aluno
		AlunoServiceImpl alunoService = AlunoServiceImpl.getInstance();
		
		CursoServiceImpl cursoService = CursoServiceImpl.getInstance();
		DisciplinaServiceImpl disciplinaService = DisciplinaServiceImpl.getInstance();
		MatriculaServiceImpl matriculaService = MatriculaServiceImpl.getInstance();
		
		System.out.println("======================= Listar todos os alunos =========================");
		
		alunoService.listar().forEach(System.out::println);
		
		System.out.println("======================= Listar alunos que residem em SP =========================");
		
		alunoService.listarPorUF("SP").forEach(System.out::println);
		
		System.out.println("======================= Listar todas disciplinas de acordo com ID do Curso 1 =========================");
		disciplinaService.listarPorCurso(1L).forEach(System.out::println);
		
		System.out.println("======================= Listar todas disciplinas de acordo com ID do Curso 2 =========================");
		disciplinaService.listarPorCurso(2L).forEach(System.out::println);
		
		System.out.println("======================= Listar todos alunos por ID do Curso 1 =========================");
		alunoService.listarPorCurso(1L).forEach(System.out::println);
		
		System.out.println("======================= Listar todos alunos por ID do Curso 2 =========================");
		alunoService.listarPorCurso(2L).forEach(System.out::println);
		
		System.out.println("======================= Listar dados b�sicos dos alunos =========================");
		alunoService.listarDadosBasicos().forEach(System.out::println);
		
		System.out.println("======================= Listar Alunos por Curso =========================");
		matriculaService.listarAlunosCursos().forEach(System.out::println);
		
		System.out.println("======================= Listar P�gina 1 de alunos =========================");
		alunoService.listarPaginado(1).forEach(System.out::println);
		
		System.out.println("======================= Listar P�gina 2 de alunos =========================");
		alunoService.listarPaginado(2).forEach(System.out::println);
		
		System.out.println("======================= Contar Alunos por Curso =========================");
		matriculaService.contarAlunosPorCurso().forEach(System.out::println);
//		//Criando 3 instâncias de Aluno
//		Aluno aluno1 = new Aluno("Aluno 1", "1111", "111.111.111-11", LocalDate.of(1980, 1, 1));
//		Aluno aluno2 = new Aluno("Aluno 2", "2222", "222.222.222-22", LocalDate.of(1990, 1, 1));
//		Aluno aluno3 = new Aluno("Aluno 3", "3333", "333.333.333-33", LocalDate.of(2000, 1, 1));
//		
//		//Inserindo no banco os alunos 1 e 2
//		alunoService.inserir(aluno1);
//		alunoService.inserir(aluno2);
//		
//		Endereco endereco = new Endereco("Av. Paulista", 777, "5 andar", "Bela Vista", "São Paulo", "SP", "04632-098");
//		
//		//Inserindo um aluno com endereço
//		alunoService.inserirComEndereco(aluno3, endereco);
//		
//		alunoService.listar().forEach(System.out::println);
//		
//		//Excluindo o aluno com id 3 e, em cascata, removendo também o endereço associado a ele
//		alunoService.remover(3L);
//		
//		alunoService.listar().forEach(System.out::println);
//		
//		//Inserindo um novo curso
//		Curso curso = new Curso("Tecnologo em Análise e Desenvolvimento de Sistemas");
//		cursoService.inserir(curso);
//		
//		cursoService.listar().forEach(System.out::println);
//		
//		//Inserindo uma nova disciplina associada ao curso criado acima
//		Disciplina disciplina = new Disciplina("EAD", 60, curso);
//		disciplina.setCurso(curso);
//		
//		disciplinaService.inserir(disciplina);
//		
//		//Efetuando a matrícula de dos alunos 1 e 2 no curso criado acima
//		Matricula matricula1 = new Matricula(aluno1, curso, LocalDate.now());
//		Matricula matricula2 = new Matricula(aluno2, curso, LocalDate.now());
//		
//		matriculaService.inserir(matricula1);
//		matriculaService.inserir(matricula2);
//		
//		matriculaService.listar().forEach(System.out::println);
	}
}
