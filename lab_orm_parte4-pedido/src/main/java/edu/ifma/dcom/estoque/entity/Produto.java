package edu.ifma.dcom.estoque.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
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

    @Setter(AccessLevel.PRIVATE)
    @Column(name = "quantidade_estoque")
    private Integer quantidaEstoque = 0;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new LinkedHashSet<>();


    public Integer getQuantidaEstoque() {
        if (Objects.isNull(quantidaEstoque))
            return 0;
        return quantidaEstoque;
    }

    /* Foi adicionado os métodos para manipular a quantidade em estoque */
    public void adicionaNoEstoque(Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um Valor Positivo");
        }
        System.out.println("########## " + this.quantidaEstoque );
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

