package edu.ifma.dcom.estoque.service;

import edu.ifma.dcom.estoque.entity.ItemPedido;
import edu.ifma.dcom.estoque.entity.Pedido;
import edu.ifma.dcom.estoque.repository.PedidoRepository;
import edu.ifma.dcom.estoque.service.exception.VendasException;
import edu.ifma.dcom.estoque.util.EMFactory;

import javax.persistence.EntityManager;

public class EstoqueService  {

	private final PedidoRepository repositorio;
	private final EntityManager manager;

	public EstoqueService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}

	public void baixarItensEstoque(Pedido pedido) throws VendasException {
        manager.getTransaction().begin();
		pedido = this.repositorio.porId(pedido.getId());
		pedido.getItens().forEach(item -> item.baixarEstoque(item.getQuantidade()));
		manager.getTransaction().commit();
	}

	public void retornarItensEstoque(Pedido pedido) {

		manager.getTransaction().begin();
		pedido = repositorio.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.adicionarEstoque(item.getQuantidade() );
		}

		manager.getTransaction().commit();

		// enviar um email para o cliente
	}
	
}