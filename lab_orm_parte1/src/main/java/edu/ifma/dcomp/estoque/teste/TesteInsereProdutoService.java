package edu.ifma.dcomp.estoque.teste;

import edu.ifma.dcomp.estoque.entity.Produto;
import edu.ifma.dcomp.estoque.service.CadastroProdutoService;

import java.math.BigDecimal;

public class InsereProdutoService {

    public static void main(String[] args) {

        Produto notebook = new Produto();
        notebook.setNome("Notebook Positivo Core 15");
        notebook.setSku("NOT1234");
        notebook.setPrecoAtual(new BigDecimal(2500.0));

        CadastroProdutoService cadastroProdutoService = new CadastroProdutoService();
        cadastroProdutoService.salva(notebook );



    }
}
