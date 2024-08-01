package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Endereco;
import edu.ifma.dcom.estoque.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TesteCliente {

	public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("lab_jpa");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // cenário
		Cliente cliente = new Cliente();
		cliente.setNome("João de Sousa");
		cliente.setCpf("123.123.123-12" );

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua da Felicidade");
		endereco.setNumero("123");
		endereco.setCep("65064-512");

		endereco.setCliente(cliente);
		
		//cliente.getEnderecos().add(endereco);
		cliente.adiciona(endereco );

		// ação
		manager.persist(cliente);
		
		transacao.commit();

		manager.close();
		factory.close();

		//verificação

	}
	
}