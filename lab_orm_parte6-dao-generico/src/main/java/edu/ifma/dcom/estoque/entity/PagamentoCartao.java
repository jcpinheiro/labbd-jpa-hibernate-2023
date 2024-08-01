package edu.ifma.dcom.estoque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento_cartao")
public final class PagamentoCartao extends Pagamento {

    @Column(name = "numero_parcelas")
    private Short numeroDeParcelas;

    public Short getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Short numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}