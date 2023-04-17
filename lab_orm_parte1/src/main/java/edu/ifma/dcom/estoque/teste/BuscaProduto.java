package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
