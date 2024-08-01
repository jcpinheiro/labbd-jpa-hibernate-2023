package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class CategoriaRepository {

	private final EntityManager manager;

	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Categoria salvaOuAtualiza(Categoria categoria) {
		if( Objects.isNull(categoria.getId()) )
			this.manager.persist(categoria);
		else
			categoria = this.manager.merge(categoria);

		return categoria;
	}

	public Categoria buscaPor(Integer id) {
		return manager.find(Categoria.class, id);
	}

	public List<Categoria> categoriasPai() {
		return manager
				//.createQuery("Select c from Categoria c where categoriaPai is null",
				.createQuery("From Categoria where categoriaPai is null",
						     Categoria.class)
				      .getResultList();
	}

	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return manager.createQuery("From Categoria where categoriaPai = :categoria", Categoria.class)
				.setParameter("categoria", categoriaPai)
				.getResultList();
	}
}