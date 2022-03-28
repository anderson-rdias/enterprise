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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="aluno",sequenceName="SB_TB_ALUNO",allocationSize=1)
@Table(name="TB_ALUNO")
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 4197318312136828812L;
	
	public Aluno() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Aluno(String nome, String matricula, String cpf, LocalDate dataNascimento) {
		this();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="aluno")
	private Long id;
	
	@Column(name="nm_aluno", length = 80)
	private String nome;
	
	@Column(name="nr_matricula", length = 10, unique = true)
	private String matricula;
	
	@Column(name="nr_cpf", length = 14, unique = true)
	private String cpf;
	
	@Column(name="dt_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name="dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Endereco endereco;
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	@Override
	public String toString() {
		return "Matr�cula: " + getMatricula()
		+ "\nNome: " + getNome()
		+ "\nCpf: " + getCpf()
		+ "\nData Nascimento: " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+ "\nEndere�o: " + this.getEndereco();
	}

}
