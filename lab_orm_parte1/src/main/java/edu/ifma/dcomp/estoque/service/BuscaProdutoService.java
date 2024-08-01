package edu.ifma.dcomp.estoque.service;

import edu.ifma.dcomp.estoque.entity.Produto;
import edu.ifma.dcomp.estoque.repository.ProdutoRepository;
import edu.ifma.dcomp.estoque.util.EMFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BuscaProdutoService {

    private final ProdutoRepository repositorio;
    private final EntityManager manager;

    public BuscaProdutoService() {
        this.manager = new EMFactory().getEntityManager();
        this.repositorio = new ProdutoRepository(manager );
    }

    public Produto buscaPorId(Integer id) {
        return repositorio.buscaPorId(id);
    }

    public Produto buscaPorSku(String sku) {
        return repositorio.buscaPorSku(sku);
    }

    public List<Produto> buscaPaginada(int qtde, int deslocamento) {
        return repositorio.buscaPaginada(qtde, deslocamento);
    }

    public List<Produto> buscaPorNome(String nome) {
        return repositorio.porNome(nome);
    }
}
