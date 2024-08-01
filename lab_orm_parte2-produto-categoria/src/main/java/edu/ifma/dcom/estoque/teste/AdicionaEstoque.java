package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AdicionaEstoque {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");
        EntityManager manager = factory.createEntityManager();


        manager.getTransaction().begin();

        Produto notebook = manager.find(Produto.class, 1);
        notebook.adicionaNoEstoque(1000);

        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}
