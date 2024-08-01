package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class InserePedido {

	public static void main(String[] args) {

		// cenário
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("lab_jpa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transacao = manager.getTransaction();

		transacao.begin();
		
		Cliente cliente = manager.find(Cliente.class, 1);
		Produto produto = manager.find(Produto.class, 1);

		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		enderecoEntrega.setLogradouro("Rua da Esperança");
		enderecoEntrega.setNumero("456");
		/*enderecoEntrega.setCidade("São Luis");
		enderecoEntrega.setUf("MA");*/
		enderecoEntrega.setCep("65123-567");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);

		// código redundante
		//pedido.setStatus(StatusPedido.ORCAMENTO);

		pedido.setDesconto(BigDecimal.TEN);
		pedido.setFrete(BigDecimal.ZERO);

		pedido.setEnderecoEntrega(enderecoEntrega);
		
		ItemPedido item = new ItemPedido();

		//item.getId().setProduto(produto );
		item.setProduto(produto );
		item.setQuantidade(10);

		//Regra de Negócio: nao posso alterar o preço
		//item.setPreco(new BigDecimal(2.32));

		item.setPedido(pedido);
		pedido.adiciona(item);
		
		manager.persist(pedido);
		
		transacao.commit();

		manager.close();
		factory.close();
	}
}