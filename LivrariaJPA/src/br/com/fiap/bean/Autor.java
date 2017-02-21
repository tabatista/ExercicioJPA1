package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.*;

import br.com.fiap.enums.Sexo;

@Entity
@Table(name = "AUTOR")
@SequenceGenerator(name = "seqAutor", sequenceName = "SQ_AUTOR", allocationSize = 1)
public class Autor {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutor")
	private int id;

	@Column(name = "NOME", nullable = false, length = 300)
	private String nome;

	@Column(name = "SOBRENNOME", nullable = false, length = 300)
	private String sobrenome;

	@Column(name = "SEXO", nullable = false)
	private Sexo sexo;

	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public Autor() {
		super();
	}

	public Autor(int id, String nome, String sobrenome, Sexo sexo, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Autor(String nome, String sobrenome, Sexo sexo, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
