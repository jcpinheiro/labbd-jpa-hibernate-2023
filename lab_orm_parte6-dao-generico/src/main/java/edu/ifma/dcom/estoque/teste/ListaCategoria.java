package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Categoria;
import edu.ifma.dcom.estoque.entity.Produto;
import edu.ifma.dcom.estoque.repository.CategoriaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class ListaCategoria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");
        EntityManager manager = factory.createEntityManager();

        CategoriaRepository repository = new CategoriaRepository(manager );
        Categoria categoria = repository.buscaPor(1);

        System.out.println(categoria );
        System.out.println("----------------------------");
        System.out.println(categoria.getSubCategorias() );

        manager.close();
        factory.close();

    }
}
