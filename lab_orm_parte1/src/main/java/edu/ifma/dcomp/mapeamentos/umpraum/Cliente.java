package edu.ifma.dcomp.mapeamentos.umpraum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@OneToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "assento_id", unique = true)
	private Assento assento;

	public Cliente() {	}

	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
	}


}
