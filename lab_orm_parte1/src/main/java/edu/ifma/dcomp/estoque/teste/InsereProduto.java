package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class InsereProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        Produto notebook = new Produto();
        notebook.setNome("Notebook Positivo Core 15");
        notebook.setPrecoAtual(new BigDecimal(2500.0));

        manager.getTransaction().begin();
        manager.persist(notebook );
        manager.getTransaction(). commit();


        manager.close();
        factory.close();

    }
}
