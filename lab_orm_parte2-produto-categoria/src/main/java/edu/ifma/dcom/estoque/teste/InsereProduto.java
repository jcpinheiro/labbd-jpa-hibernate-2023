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

        manager.getTransaction().begin();
        Categoria informatica = manager.find(Categoria.class, 1);

        Produto notebook = Produto.builder()
                .nome("Notebook Acer Core i7")
                .precoAtual(new BigDecimal(4000.0))
                .categorias(Set.of(informatica))
                .build();

        manager.persist(notebook );
        manager.getTransaction().commit();


        manager.close();
        factory.close();

    }
}
