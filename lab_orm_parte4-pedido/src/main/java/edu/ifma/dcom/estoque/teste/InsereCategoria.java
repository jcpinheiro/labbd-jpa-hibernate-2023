package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsereCategoria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        cadastraCategoria(manager );
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
