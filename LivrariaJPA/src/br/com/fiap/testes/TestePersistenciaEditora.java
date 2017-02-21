package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.bean.*;

/**
 * 
 * @author Thais Poentes - RM 76766 - 2TDSS - NOTURNO - ACLIMAÇÃO
 *
 */
public class TestePersistenciaEditora {

	public static void main(String[] args) {

		// Criando o entity
		// valor na string configurado no persistence.xml em "persistence-unit"
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("LIVRARIA_ORACLE");
		EntityManager manager = fabrica.createEntityManager();

		/**
		 * Adicionando Dados na tabela Editora
		 */

		// setando valores
		Editora editora = new Editora("14544", "Orange", "Rua Sharon");

		// persistindo dados da editora
		manager.persist(editora);

		// Transação - inicializar a persistência e comitar no banco
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Editora cadastrada!");
		/**
		 * Alterando Dados na tabela Editora
		 */

		// buscar a entidade editora
		// Classe // codigo
		Editora editora2 = manager.find(Editora.class, 1);

		// alterando valor
		editora2.setEndereco("Rua Canções de Sharon");

		// atualizando
		manager.merge(editora2);

		// inicializando transação e comitando
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Editora atualizada!");

		/**
		 * Consultando Dados da tabela Editora
		 */

		// buscando dados
		Editora editora3 = manager.find(Editora.class, 1);

		// exibindo nome editora
		System.out.println("Editora: " + editora3.getNome());

		System.out.println("Editora Consultada!");

		/**
		 * Fazendo Refresh na tabela Editora
		 */

		// reutilizando dados da editora3
		System.out.println("Valor atual da editora" + editora3.getNome());
		editora3.setNome("OrangeEditado");
		System.out.println("Valor editado antes do Refresh: " + editora3.getNome());
		manager.refresh(editora3);
		System.out.println("Valor após refresh: " + editora3.getNome());

		/**
		 * Removendo Dados da tabela Editora
		 */

		// reutilizando dados da editora3
		manager.remove(editora3);

		// transação
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		System.out.println("Editora removida!");

		manager.close();

	}

}
