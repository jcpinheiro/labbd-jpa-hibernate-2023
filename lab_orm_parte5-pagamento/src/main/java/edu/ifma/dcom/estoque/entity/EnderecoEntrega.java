package edu.ifma.dcom.estoque.entity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public @Data class EnderecoEntrega {

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    @Column(name = "endereco_cep")
    private String cep;


}