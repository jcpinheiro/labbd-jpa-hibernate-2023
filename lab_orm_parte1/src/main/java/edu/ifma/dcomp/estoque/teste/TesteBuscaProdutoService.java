package edu.ifma.dcomp.estoque.teste;

import edu.ifma.dcomp.estoque.service.BuscaProdutoService;

public class TesteBuscaProdutoService {

    public static void main(String[] args) {

        BuscaProdutoService service = new BuscaProdutoService();

        service.buscaPaginada(3,1)
               .forEach(System.out::println);

        System.out.println("------------------------");
        service.buscaPorNome("i7")
                .forEach(System.out::println);


    }
}
