package edu.ifma.dcom.estoque.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai", nullable = true)
    private Categoria categoriaPai;

   @OneToMany(mappedBy = "categoriaPai")
    private Set<Categoria> subCategorias = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoriaPai=" + categoriaPai +
                '}';
    }
}