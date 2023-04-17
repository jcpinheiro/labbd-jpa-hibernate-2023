package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ListaProdutos {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.createQuery("From Produto", Produto.class)
               .getResultList()
               .forEach(produto -> produto.setPrecoAtual(new BigDecimal(4000)));

        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}
