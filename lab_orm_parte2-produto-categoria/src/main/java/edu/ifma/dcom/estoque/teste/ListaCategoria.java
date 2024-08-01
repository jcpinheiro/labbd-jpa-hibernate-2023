package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ListaCategoria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");
        EntityManager manager = factory.createEntityManager();

        Categoria categoriaPai = manager.find(Categoria.class, 1);
        System.out.println("Categoria Pai : " + categoriaPai.getNome() );
        System.out.println("---------------------------------");
        System.out.println(categoriaPai.getSubCategorias());
        System.out.println("---------------------------------");

        List<Categoria> subCategorias = manager
                .createQuery("from Categoria where categoriaPai = :categoria", Categoria.class)
                .setParameter("categoria", categoriaPai)
                .getResultList();

        System.out.println("---------- subcategorias ---------");
        subCategorias.forEach(categoria -> System.out.println(categoria ));


        manager.close();
        factory.close();

    }
}
