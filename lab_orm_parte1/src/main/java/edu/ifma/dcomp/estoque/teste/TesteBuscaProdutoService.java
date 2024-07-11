package edu.ifma.dcomp.estoque.teste;

import edu.ifma.dcomp.estoque.entity.Produto;
import edu.ifma.dcomp.estoque.service.CadastroProdutoService;

import java.math.BigDecimal;

public class TesteInsereProdutoService {

    public static void main(String[] args) {

        Produto notebook = new Produto();
        notebook.setNome("Notebook Acer Core 19");
        notebook.setSku("NOT3234");
        notebook.setPrecoAtual(new BigDecimal(5500.0));

        CadastroProdutoService cadastroProdutoService = new CadastroProdutoService();
        cadastroProdutoService.salva(notebook );



    }
}
