package br.com.fiap.main;

import br.com.fiap.entity.Disciplina;
import br.com.fiap.jpa.service.impl.DisciplinaServiceImpl;



public class DisciplinaTeste {
	
	public static void main(String[] args) {
		DisciplinaServiceImpl disciplinaService = DisciplinaServiceImpl.getInstance();
		
		Disciplina disciplina1 = new Disciplina ("Database", 123);
		Disciplina disciplina2 = new Disciplina ("Enterprise", 456);
		Disciplina disciplina3 = new Disciplina ("Mobile", 789);
		
		disciplinaService.inserir(disciplina1);
		disciplinaService.inserir(disciplina2);
		disciplinaService.inserir(disciplina3);
		
	}

}
