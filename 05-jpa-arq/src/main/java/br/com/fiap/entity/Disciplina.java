package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="disciplina",sequenceName="SB_TB_DISCIPLINA",allocationSize=1)
@Table(name="TB_DISCIPLINA")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -5251911685589156180L;
	
	public Disciplina() {
		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Disciplina(String nome, Integer cargaHoraria) {
		this();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="disciplina")
	private Long id;
	
	@Column(name="nm_disciplina", length = 80)
	private String nome;
	
	@Column(name="carga_horaria", length = 10)
	private Integer cargaHoraria;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name="dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Curso curso;
	
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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@Override
	public String toString() {
		return "Disciplina: " + getNome()
		+ "\nCarga Horária: " + getCargaHoraria() + " Horas";
	}
	
}
