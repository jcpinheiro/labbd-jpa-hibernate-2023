package edu.ifma.dcomp.mapeamentos.umpraum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteMapeamentoOneToOne {

    public static void main(String[] args) {

        Assento assento = new Assento("5C");
        Cliente cliente = new Cliente("Joao", assento);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidovendas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        //manager.persist(assento );
        manager.persist(cliente );

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
