package edu.ifma.dcomp.estoque.service;

import edu.ifma.dcomp.estoque.entity.Produto;
import edu.ifma.dcomp.estoque.repository.ProdutoRepository;
import edu.ifma.dcomp.estoque.service.exception.VendasException;
import edu.ifma.dcomp.estoque.util.EMFactory;
import jakarta.persistence.EntityManager;

import java.util.Objects;

public class CadastroProdutoService {

	private final ProdutoRepository repositorio;
	private final EntityManager manager;

	public CadastroProdutoService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new ProdutoRepository(manager );
	}

	public Produto salva(Produto produto) throws VendasException {
		try {
			manager.getTransaction().begin();
			Produto produtoExistente = repositorio.buscaPorSku(produto.getSku());

			if (Objects.nonNull(produtoExistente) && !Objects.equals(produto, produtoExistente)) {
				throw new VendasException("Já existe um produto com o SKU informado.");
			}
			Produto produtoSalvo = repositorio.salvaOuAtualiza(produto);
			// ...
			manager.getTransaction().commit();
			return produtoSalvo;

		} catch	(Exception e) {
			throw new RuntimeException(e );
		}
	}
	
}