package edu.ifma.dcom.estoque.entity;

import edu.ifma.dcom.estoque.entity.enums.TipoCliente;
import lombok.*;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public @Data class Cliente  {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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