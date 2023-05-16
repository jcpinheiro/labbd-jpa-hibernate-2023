package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Endereco;
import edu.ifma.dcom.estoque.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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