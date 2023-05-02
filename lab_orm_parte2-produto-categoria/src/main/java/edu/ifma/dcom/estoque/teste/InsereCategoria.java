package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class InsereCategoria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

//        cadastraCategoria(manager );

        cadastrarSubCategoria(manager, "HD Externo");
        cadastrarSubCategoria(manager, "Pen Drive");
        manager.close();
        factory.close();
    }

    private static void cadastraCategoria(EntityManager manager) {
        Categoria informatica = Categoria.builder()
                .nome("Informática")
                .build();

        manager.getTransaction().begin();
        manager.persist(informatica );
        manager.getTransaction().commit();
    }

    private static void cadastrarSubCategoria(EntityManager manager, String nome) {

        manager.getTransaction().begin();
        Categoria informatica = manager.find(Categoria.class, 1);
        Categoria subCategoria = Categoria.builder()
                .nome(nome)
                .categoriaPai(informatica)
                .build();

        manager.persist(subCategoria );
        manager.getTransaction().commit();
    }
}
