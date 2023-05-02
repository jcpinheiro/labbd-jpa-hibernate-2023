package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

public class ProdutoRepository {

    private final EntityManager manager;

    public ProdutoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Produto buscaPorId(Integer id) {
        return manager.find(Produto.class, id);
    }

    public Produto buscaPorSku(String sku) {
        try {
            Produto produto =
                    manager.createQuery("from Produto where upper(sku) = :sku",
                    Produto.class)
                    .setParameter("sku", sku.toUpperCase())
                    .getSingleResult();
            return produto;

        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Produto> porNome(String nome) {
        return this.manager
                .createQuery("from Produto where upper(nome) like :nome", Produto.class)
                .setParameter("nome", "%" + nome.toUpperCase() + "%")
                .getResultList();
    }

    public Produto salvaOuAtualiza(Produto produto) {
        if( Objects.isNull(produto.getId()) )
            this.manager.persist(produto);
        else
            produto = this.manager.merge(produto);



        return produto;
    }
}