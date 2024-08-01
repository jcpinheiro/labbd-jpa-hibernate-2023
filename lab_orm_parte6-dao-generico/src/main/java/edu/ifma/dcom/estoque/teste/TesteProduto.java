package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class TesteProduto {

	public static void main(String[] args) {
        // cenário

		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setNome("Caderno de 10 materias");
		produto.setPrecoAtual(new BigDecimal(12.91) );
		produto.adicionaNoEstoque(100 );

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("lab_jpa");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transacao = manager.getTransaction();

		transacao.begin();
		//ação
	    manager.persist(produto);
		transacao.commit();

		manager.close();
		factory.close();

		// Verificação
		System.out.println(produto );
	}
	
}