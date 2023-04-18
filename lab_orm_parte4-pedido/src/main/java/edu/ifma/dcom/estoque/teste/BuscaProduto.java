package edu.ifma.dcom.estoque.teste;

import edu.ifma.dcom.estoque.entity.Produto;
import edu.ifma.dcom.estoque.repository.ProdutoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
