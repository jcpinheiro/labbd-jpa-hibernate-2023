package edu.ifma.dcom.estoque.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class ItemPedidoPK implements Serializable {

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    Pedido getPedido() {
        return pedido;
    }

    void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    Produto getProduto() {
        return produto;
    }

    void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }
}