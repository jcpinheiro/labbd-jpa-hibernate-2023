package edu.ifma.dcom.estoque.entity;

import edu.ifma.dcom.estoque.entity.enums.SituacaoPagamento;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public @Data abstract class Pagamento {


    @Id
    private Integer id;

    @OneToOne @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;


    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private SituacaoPagamento situacaoPagamento;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(pedido, pagamento.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido);
    }
}