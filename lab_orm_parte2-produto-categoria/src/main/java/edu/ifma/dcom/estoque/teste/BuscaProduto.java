package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class BuscaProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        Produto produto = manager.find(Produto.class, 3);
        produto.setNome("Notebook Positivo");

        manager.getTransaction().commit();

        System.out.println(produto );


        manager.close();
        factory.close();

    }
}
