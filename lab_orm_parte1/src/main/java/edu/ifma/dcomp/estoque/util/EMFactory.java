package edu.ifma.dcomp.estoque.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFactory implements AutoCloseable {

    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("pedidovendas");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public void close() {
        factory.close();
    }
}