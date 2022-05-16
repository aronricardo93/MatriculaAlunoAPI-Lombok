package com.curso.tecnico.dtos.curso;

import com.curso.tecnico.models.Curso;

public class CursoMapper {

	public static Curso fromDTO(RegistroCursoDTO dto) {
		return new Curso(dto.getId());
	}
	
	public static ConsultaCursoDTO fromEntity(Curso curso) {
		return new ConsultaCursoDTO(curso.getId());
	}
	
}
