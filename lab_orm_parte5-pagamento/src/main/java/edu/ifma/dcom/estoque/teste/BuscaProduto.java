package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;
import edu.ifma.dcom.estoque.repository.ProdutoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class BuscaProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("lab_jpa");

        EntityManager manager = factory.createEntityManager();


        ProdutoRepository repository = new ProdutoRepository(manager);
        List<Produto> produtos = repository.porNome("Notebook");

        produtos.forEach(System.out::println);


        manager.close();
        factory.close();

    }
}
