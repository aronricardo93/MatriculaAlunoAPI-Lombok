package com.curso.tecnico.dtos.aluno;

import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.br.CPF;

import com.curso.tecnico.dtos.curso.RegistroCursoDTO;
import com.curso.tecnico.models.Curso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistroAlunoDTO {

	private String nome;
	
	@CPF
	private String cpf;
	
	@OneToOne
	private RegistroCursoDTO curso;
}
