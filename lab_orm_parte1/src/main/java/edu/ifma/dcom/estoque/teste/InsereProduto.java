package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class InsereProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        Produto notebook = new Produto();
        notebook.setNome("Notebook Acer Core 19");
        notebook.setPrecoAtual(new BigDecimal(4000.0));

        manager.getTransaction().begin();
        manager.persist(notebook );
        manager.getTransaction(). commit();


        manager.close();
        factory.close();

    }
}
