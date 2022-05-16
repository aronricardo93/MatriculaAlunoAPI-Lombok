package com.curso.tecnico.dtos.aluno;

import com.curso.tecnico.dtos.curso.CursoMapper;
import com.curso.tecnico.models.Aluno;

public class AlunoMapper {

	public static Aluno fromDTO(RegistroAlunoDTO dto) {
		return new Aluno(null, dto.getNome(), dto.getCpf(), CursoMapper.fromDTO(dto.getCurso()));
	}
	
	public static ConsultaAlunoDTO fromEntity(Aluno aluno) {
		return new ConsultaAlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCpf(), CursoMapper.fromEntity(aluno.getCurso()));
	}
	
}
