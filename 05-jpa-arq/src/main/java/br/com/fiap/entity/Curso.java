package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="curso",sequenceName="SB_TB_CURSO",allocationSize=1)
@Table(name="TB_CURSO")
public class Curso implements Serializable{
	
	private static final long serialVersionUID = 5108232082300642010L;
	
	public Curso() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Curso(String nome) {
		this();
		this.nome = nome;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="curso")
	private Long id;
	
	@Column(name="ds_aluno", length = 80, nullable = false)
	private String nome;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name="dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	

}
