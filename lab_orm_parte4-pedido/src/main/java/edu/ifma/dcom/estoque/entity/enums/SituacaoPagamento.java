package edu.ifma.dcom.estoque.entity.enums;

public enum SituacaoPagamento {

    ORCAMENTO ("Orcamento"),
    QUITADO ("Quitado"),
    CANCELADO ("Cancelado");

    private String situacao;

    private SituacaoPagamento(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }
}