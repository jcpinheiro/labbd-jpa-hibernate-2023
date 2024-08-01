package edu.ifma.dcom.estoque.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

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
                "nome='" + nome + '\'' +
                '}';
    }
}