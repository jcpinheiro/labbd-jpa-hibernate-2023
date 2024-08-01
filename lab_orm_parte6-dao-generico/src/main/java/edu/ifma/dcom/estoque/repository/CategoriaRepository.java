package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.Categoria;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class CategoriaRepository  {

	private final EntityManager manager;
	private final DAOGenerico<Categoria> daoGenerico;

	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<>(manager);
	}

	public Categoria salvaOuAtualiza(Categoria categoria) {
		return daoGenerico.salvaOuAtualiza(categoria);
	}

	public Categoria buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Categoria.class, id);
	}


	public List<Categoria> categoriasPai() {
		return manager
				.createQuery("Select c from Categoria c where categoriaPai is null", Categoria.class)
				.getResultList();
	}


	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return manager.createQuery("from Categoria where categoriaPai = :categoria", Categoria.class)
				.setParameter("categoria", categoriaPai)
				.getResultList();
	}

}