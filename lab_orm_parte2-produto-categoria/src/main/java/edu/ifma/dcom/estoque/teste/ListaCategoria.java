package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class ListaCategoria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");
        EntityManager manager = factory.createEntityManager();

        Categoria categoriaPai = manager.find(Categoria.class, 1);
        List<Categoria> categorias = manager
                .createQuery("from Categoria where categoriaPai = :categoria", Categoria.class)
                .setParameter("categoria", categoriaPai)
                .getResultList();

        categorias.forEach(categoria -> System.out.println(categoria.getNome() ));


        manager.close();
        factory.close();

    }
}
