package edu.ifma.dcom.estoque.entity.enums;

public enum TipoCliente {

    FISICA("Pessoa Física"),
    JURIDICA("Pessoa Jurídica");

    private final String tipo;

    private TipoCliente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}