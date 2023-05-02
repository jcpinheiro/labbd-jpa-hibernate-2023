package edu.ifma.dcom.estoque.entity;

import edu.ifma.dcom.estoque.entity.Endereco;
import edu.ifma.dcom.estoque.entity.enums.TipoCliente;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class Cliente  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new LinkedHashSet<>();

    @ElementCollection
    @Column(name = "telefone", nullable = false)
    @CollectionTable(name = "telefones", joinColumns = @JoinColumn(name = "cliente_id", nullable = false))
    private Set<String> telefones = new LinkedHashSet<>();

    public void adiciona(Endereco endereco) {
        enderecos.add(endereco );
    }

}