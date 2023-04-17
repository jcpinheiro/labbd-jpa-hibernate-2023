package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class InsereProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();


        Categoria categoria = Categoria.builder()
                .nome("Informática")
                .build();
        manager.getTransaction().begin();
        manager.persist(categoria );
        manager.getTransaction().commit();

        manager.getTransaction().begin();


        Categoria informatica = manager.find(Categoria.class, 1);

        Produto produto1 = Produto.builder()
                .nome("Notebook Acer Core i7")
                .precoAtual(new BigDecimal(4000.0))
                .categorias(Set.of(informatica))
                .build();

        Produto produto2 = Produto.builder()
                .nome("Notebook Dell Core i7")
                .precoAtual(new BigDecimal(5000.0))
                .categorias(Set.of(informatica))
                .build();

        Produto produto3 = Produto.builder()
                .nome("Smartphone Samsung s10")
                .precoAtual(new BigDecimal(4500.0))
                .categorias(Set.of(informatica))
                .build();

        manager.persist(produto1 );
        manager.persist(produto2 );
        manager.persist(produto3 );

        manager.getTransaction().commit();


        manager.close();
        factory.close();

    }
}
