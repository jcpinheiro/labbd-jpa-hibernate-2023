package edu.ifma.dcom.estoque.service;

import edu.ifma.dcom.estoque.entity.Pedido;
import edu.ifma.dcom.estoque.repository.PedidoRepository;
import edu.ifma.dcom.estoque.service.exception.VendasException;
import edu.ifma.dcom.estoque.util.EMFactory;

import javax.persistence.EntityManager;

public class EmissaoPedidoService {

	private final PedidoRepository repositorio;
	private final EntityManager manager;


	public EmissaoPedidoService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}


	//@Transactional
	public Pedido emitir(Pedido pedido) throws VendasException {

		manager.getTransaction().begin();

		repositorio.salvaOuAtualiza(pedido );

		/*this.estoqueService.baixarItensEstoque(pedido);
		pedido.setStatus(StatusPedido.FINALIZADO);*/

		pedido.finaliza();

		manager.getTransaction().commit();
		
		return pedido;
	}
	
}