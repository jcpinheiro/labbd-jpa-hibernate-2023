package edu.ifma.dcomp.estoque.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

@Data @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @AllArgsConstructor
@Entity //@Table(name = "tbl_produto")
public class Produto {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String sku;

    @Column(name = "preco_atual")
    private BigDecimal precoAtual;

    @Setter(AccessLevel.NONE)
    @Column(name = "quantidade_estoque")
    private Integer quantidaEstoque = 0;

    public Integer getQuantidaEstoque() {
        if (isNull(quantidaEstoque) )
            return 0;
        return quantidaEstoque;
    }

    /* Foi adicionado os métodos para manipular a quantidade em estoque */
    public void adicionaNoEstoque(Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um Valor Positivo");
        }
        this.quantidaEstoque = this.getQuantidaEstoque() + quantidade;
    }

    public void baixaNoEstoque(Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um Valor Positivo");
        }
        Integer novaQuantidade = this.getQuantidaEstoque() - quantidade;

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Não há disponibilidade no estoque de "
                    + quantidade + " itens do produto " + this.getSku() + ".");
        }
        this.quantidaEstoque = novaQuantidade;
    }
}
