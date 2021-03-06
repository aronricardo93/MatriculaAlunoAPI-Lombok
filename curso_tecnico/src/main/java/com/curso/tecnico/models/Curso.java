package com.curso.tecnico.models;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String nome;
	
	@OneToMany
	private List<Aluno> alunos;

	public Curso(Long id) {
		this.id = id;
	}
	
	
}
