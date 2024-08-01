package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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
        Categoria eletronico = manager.find(Categoria.class, 2);

        Produto notebook = Produto.builder()
                .nome("Notebook Samsung Core i7")
                .precoAtual(new BigDecimal(4700.0))
                .categorias(Set.of(informatica, eletronico) )
                .build();

        manager.merge(notebook );
        manager.getTransaction().commit();


        manager.close();
        factory.close();

    }
}
