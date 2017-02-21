package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.Livro;

/**
 * 
 * @author Thais Poentes - RM 76766 - 2TDSS - NOTURNO - ACLIMAÇÃO
 *
 */
public class TestePersistenciaLivro {

	public static void main(String[] args) {

		// Criando o entity
				// valor na string configurado no persistence.xml em "persistence-unit"
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("LIVRARIA_ORACLE");
				EntityManager manager = fabrica.createEntityManager();

				/**
				 * Adicionando Dados na tabela Editora
				 */

				// setando valores
				Livro livro = new Livro("Alvaro de Campos", 54.50f, new GregorianCalendar(1946,Calendar.AUGUST, 17), null);

				// persistindo dados do Autor
				manager.persist(livro);

				// Transação - inicializar a persistência e comitar no banco
				manager.getTransaction().begin();
				manager.getTransaction().commit();

				System.out.println("Livro cadastrado!");
				
				/**
				 * Alterando Dados na tabela Livro
				 */

				// buscar a entidade livro
											// Classe // codigo
				Livro livro2 = manager.find(Livro.class, 1);

				// alterando valor
				livro2.setTitulo("Antologia Poetica Alvaro de Campos");

				// atualizando
				manager.merge(livro2);

				// inicializando transação e comitando
				manager.getTransaction().begin();
				manager.getTransaction().commit();

				System.out.println("Livro atualizado!");

				/**
				 * Consultando Dados da tabela Livro
				 */

				// buscando dados
				Livro livro3 = manager.find(Livro.class, 1);

				// exibindo nome livro
				System.out.println("Livro: " + livro3.getTitulo());

				System.out.println("Livro Consultado!");

				/**
				 * Fazendo Refresh na tabela Livro
				 */

				// reutilizando dados do livro3
				System.out.println("Titulo atual do Livro" + livro3.getTitulo());
				livro3.setTitulo("TituloEditado");
				System.out.println("Titulo editado antes do Refresh: " + livro3.getTitulo());
				manager.refresh(livro3);
				System.out.println("Titulo após refresh: " + livro3.getTitulo());

				/**
				 * Removendo Dados da tabela Livro
				 */

				// reutilizando dados do livro3
				manager.remove(livro3);

				// transação
				manager.getTransaction().begin();
				manager.getTransaction().commit();
				
				System.out.println("Livro removido!");

				manager.close();

	}

}
