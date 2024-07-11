package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class ListaProdutos {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("From Produto", Produto.class)
               .getResultList()
               //.forEach(produto -> produto.setPrecoAtual(new BigDecimal(4000)))
               .forEach(System.out::println);

        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}
