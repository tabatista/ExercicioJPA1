package br.com.fiap.bean;

import javax.persistence.*;

@Entity
@Table(name = "EDITORA")
@SequenceGenerator(name = "seqEditora", sequenceName = "SQ_EDITORA", allocationSize = 1)
public class Editora {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEditora")
	private int id;

	@Column(name = "CNPJ", nullable = false, length = 100)
	private String cnpj;

	@Column(name = "NOME", nullable = false, length = 300)
	private String nome;

	@Column(name = "ENDERECO", length = 400)
	private String endereco;

	public Editora() {
		super();
	}

	public Editora(int id, String cnpj, String nome, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Editora(String cnpj, String nome, String endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
