package br.com.fiap.jpa.dto;

public class TotalAlunosCursoDTO {
	
	private String nomeCurso;
	private long qtdAlunos;
	
	public TotalAlunosCursoDTO() {
		
	}
	
	public TotalAlunosCursoDTO(String nomeCurso, long qtdAlunos) {
		this.nomeCurso = nomeCurso;
		this.qtdAlunos = qtdAlunos;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public long getQtdAlunos() {
		return qtdAlunos;
	}
	public void setQtdAlunos(long qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}
	
	@Override
	public String toString() {
		return "\nNome do curso: " + this.getNomeCurso() +
			   "\nQuantidade de alunos: " + this.getQtdAlunos();
	}
	

}
