package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Autor;
import br.com.fiap.enums.Sexo;

/**
 * 
 * @author Thais Poentes - RM 76766 - 2TDSS - NOTURNO - ACLIMAÇÃO
 *
 */
public class TestePersistenciaAutor {

	public static void main(String[] args) {

		// Criando o entity
		// valor na string configurado no persistence.xml em "persistence-unit"
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("LIVRARIA_ORACLE");
		EntityManager manager = fabrica.createEntityManager();

		/**
		 * Adicionando Dados na tabela Autor
		 */

		// setando valores
		Autor autor = new Autor("Fernandoo", "Pessoa", Sexo.MASCULINO, new GregorianCalendar(1888, Calendar.JUNE, 13));

		// persistindo dados do Autor
		manager.persist(autor);

		// Transação - inicializar a persistência e comitar no banco
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Autor cadastrado!");

		/**
		 * Alterando Dados na tabela Livro
		 */

		// buscar a entidade Autor
		// Classe // codigo
		Autor autor2 = manager.find(Autor.class, 1);

		// alterando valor
		autor2.setNome("Fernando");

		// atualizando
		manager.merge(autor2);

		// inicializando transação e comitando
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Autor atualizado!");

		/**
		 * Consultando Dados da tabela Autor
		 */

		// buscando dados
		Autor autor3 = manager.find(Autor.class, 1);

		// exibindo nome livro
		System.out.println("Autor: " + autor3.getNome() + " " + autor3.getSobrenome());

		System.out.println("Autor Consultado!");

		/**
		 * Fazendo Refresh na tabela Autor
		 */

		// reutilizando dados do autor3
		System.out.println("Nome atual do Autor" + autor3.getNome());
		autor3.setNome("NomeEditado");
		System.out.println("Nome editado antes do Refresh: " + autor3.getNome());
		manager.refresh(autor3);
		System.out.println("Nome após refresh: " + autor3.getNome());

		/**
		 * Removendo Dados da tabela Autor
		 */

		// reutilizando dados do autor3
		manager.remove(autor3);

		// transação
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Autor removido!");

		manager.close();

	}

}
