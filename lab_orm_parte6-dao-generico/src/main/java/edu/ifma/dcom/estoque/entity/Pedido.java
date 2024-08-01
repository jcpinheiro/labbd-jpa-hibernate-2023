package edu.ifma.dcom.estoque.entity;

import edu.ifma.dcom.estoque.entity.Cliente;
import edu.ifma.dcom.estoque.entity.enums.EstadoPedido;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedido")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class Pedido implements EntidadeBase {

   @EqualsAndHashCode.Include
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Setter(AccessLevel.NONE)
   private LocalDateTime instanteCriacao;

    private BigDecimal frete = BigDecimal.ZERO;

    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(columnDefinition = "text")
    private String observacoes;


    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itens = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido = EstadoPedido.ORCAMENTO;

    @ManyToOne
    private Cliente cliente;

    @Embedded
    private EnderecoEntrega enderecoEntrega;

    @PrePersist
    private void prePersit() {
        this.instanteCriacao = LocalDateTime.now();
    }


    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void finaliza() {
        this.estadoPedido = estadoPedido.finaliza();
    }

    public void cancela() {
        this.estadoPedido = estadoPedido.cancela();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Transient
    public BigDecimal getTotal() {
    // solução 01
      /* BigDecimal total = BigDecimal.ZERO;
       for(ItemPedido item: itens) {
           total = total.add(item.getSubTotal() );
       }
       return total.add(frete).subtract(desconto);*/
    // solução 02
      /* return itens.stream()
               .map(item -> item.getSubTotal())
               .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));*/
    // solução 03
       BigDecimal total = itens.stream()
                               .map(ItemPedido::getSubTotal)
                               .reduce(BigDecimal.ZERO, BigDecimal::add);

       return total.add(frete).subtract(desconto);
    }


    public void adiciona(ItemPedido item) {

        if (aindaNaoPossuiO(item)) {
            itens.add(item );

        } else {
            item.aumentaQuantidade(item.getQuantidade() );
        }
    }

    private boolean aindaNaoPossuiO(ItemPedido item) {
        return !itens.contains(item);
    }
}