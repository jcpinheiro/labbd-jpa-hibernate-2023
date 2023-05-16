package edu.ifma.dcom.estoque.service;

import edu.ifma.dcom.estoque.entity.Pedido;
import edu.ifma.dcom.estoque.repository.PedidoRepository;
import edu.ifma.dcom.estoque.util.EMFactory;

import javax.persistence.EntityManager;

public class CancelamentoPedidoService  {

	private final PedidoRepository repositorio;
	private final EntityManager manager;

	public CancelamentoPedidoService( ) {

		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}


	public Pedido cancela(Pedido pedido) {

		manager.getTransaction().begin();

		pedido = repositorio.porId(pedido.getId());
		pedido.cancela();

		manager.getTransaction().commit();

		// envia email para o cliente
		//mailService.enviaMensagemDeCancelamentoPara(pedido.getCliente() );

		return pedido;
	}

}