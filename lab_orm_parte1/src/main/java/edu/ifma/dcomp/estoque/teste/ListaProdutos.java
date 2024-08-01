package edu.ifma.dcomp.estoque.teste;

import edu.ifma.dcomp.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ListaProdutos {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("pedidovendas");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("From Produto", Produto.class)
                //.setMaxResults(2)
                .getResultList()
               //.forEach(produto -> produto.setPrecoAtual(new BigDecimal(4000)))
               .forEach(System.out::println);

        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}
