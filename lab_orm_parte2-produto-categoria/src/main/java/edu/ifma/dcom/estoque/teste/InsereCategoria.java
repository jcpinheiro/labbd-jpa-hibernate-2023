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

        cadastrarSubCategoria(manager, "Camisa de Algodão");
        cadastrarSubCategoria(manager, "Calça Jeans");
        manager.close();
        factory.close();
    }

    private static void cadastraCategoria(EntityManager manager) {
        Categoria roupas = Categoria.builder()
                .nome("Roupas")
                .build();
        Categoria alimentos = Categoria.builder()
                .nome("Alimentos")
                .build();

        manager.getTransaction().begin();
        manager.persist(roupas );
        manager.persist(alimentos );
        manager.getTransaction().commit();
    }

    private static void cadastrarSubCategoria(EntityManager manager, String nome) {

        manager.getTransaction().begin();
        Categoria roupas = manager.find(Categoria.class, 1);
        Categoria subCategoria = Categoria.builder()
                .nome(nome)
                .categoriaPai(roupas)
                .build();

        manager.persist(subCategoria );
        manager.getTransaction().commit();
    }
}
