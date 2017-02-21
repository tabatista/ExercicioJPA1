package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "LIVRO")
@SequenceGenerator(name = "seqLivro", sequenceName = "SQ_LIVRO", allocationSize = 1)
public class Livro {

	@Id
	@Column(name = "ISBN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLivro")
	private int isbn;

	@Column(name = "TITULO", nullable = false, length = 200)
	private String titulo;

	@Column(name = "PRECO")
	private float preco;

	@Column(name = "DT_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;

	@Lob
	@Column(name = "CAPA")
	private byte[] capa;

	public Livro() {
		super();
	}

	public Livro(int isbn, String titulo, float preco, Calendar dataLancamento, byte[] capa) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	public Livro(String titulo, float preco, Calendar dataLancamento, byte[] capa) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

}
