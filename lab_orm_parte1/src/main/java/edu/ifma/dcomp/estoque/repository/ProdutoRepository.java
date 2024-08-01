package edu.ifma.dcomp.estoque.repository;

import edu.ifma.dcomp.estoque.entity.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

import static java.util.Objects.isNull;

public class ProdutoRepository {

    private final EntityManager manager;

    public ProdutoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Produto buscaPorId(Integer id) {
        return manager.find(Produto.class, id);
    }

    public Produto buscaPorSku(String sku) {
           Produto produto =
                    manager.createQuery("from Produto where upper(sku) = :sku",
                                            Produto.class)
                            .setParameter("sku", sku.toUpperCase())
                            .getSingleResultOrNull();
            return produto;
    }

    public List<Produto> buscaPaginada(int qtde, int deslocamento) {
              String jpql = "select p from Produto p";

        return  manager.createQuery(jpql, Produto.class)
                    .setMaxResults(qtde)
                    .setFirstResult(deslocamento)
                    .getResultList();
    }

    public List<Produto> porNome(String nome) {
        return this.manager
                .createQuery("from Produto p where upper(nome) like :nome", Produto.class)
                .setParameter("nome", "%" + nome.toUpperCase() + "%")
                .getResultList();
    }

    public Produto salvaOuAtualiza(Produto produto) {

        if( isNull(produto.getId()) )
            this.manager.persist(produto);
        else
            produto = this.manager.merge(produto);

        return produto;
    }
}