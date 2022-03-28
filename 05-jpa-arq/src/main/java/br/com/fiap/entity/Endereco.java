package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name="endereco",sequenceName="SB_TB_ENDERECO",allocationSize=1)
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = -446237258611945317L;
	
	public Endereco() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Endereco(String rua, Integer numero, String complemento, String bairro,
			String cidade, String uf, String cep) {
		this();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	
	@Id
	private Long id;
	
	@Column(name = "ds_rua", length = 50, nullable = false)
	private String rua;
	
	@Column(name = "nr_endereco", nullable = false)
	private Integer numero;
	
	@Column(name = "nr_cep", length = 9, nullable = false)
	private String cep;
	
	@Column(name = "ds_complemento", length = 20)
	private String complemento;
	
	@Column(name = "ds_bairro", length = 20, nullable = false)
	private String bairro;
	
	@Column(name = "ds_cidade", length = 50, nullable = false)
	private String cidade;
	
	@Column(name = "ds_uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name="dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@OneToOne(optional = false)
	@MapsId
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		return this.getRua() + ", " + this.getNumero() + ", " + this.getComplemento()
		+ ", " + this.getBairro() + ", " + this.getCidade() + ","
		+ this.getUf() + " - " + this.getCep();
	}
	
	
}
