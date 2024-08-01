package edu.ifma.dcom.estoque.repository;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

public class ProdutoRepository {

    private final EntityManager manager;
    private final DAOGenerico<Produto> daoGenerico;


    public ProdutoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Produto>(manager);

    }

    public Produto buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Produto.class, id);
    }

    public Produto buscaPorSku(String sku) {
        try {
            Produto produto = manager.createQuery("from Produto where upper(sku) = :sku",
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
        return daoGenerico.salvaOuAtualiza(produto );

    }

    public void remover(Produto produto)  {
        daoGenerico.remove(produto );
    }

}