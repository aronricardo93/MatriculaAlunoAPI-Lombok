package com.curso.tecnico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.tecnico.dtos.aluno.AlunoMapper;
import com.curso.tecnico.dtos.aluno.ConsultaAlunoDTO;
import com.curso.tecnico.dtos.aluno.RegistroAlunoDTO;
import com.curso.tecnico.models.Aluno;
import com.curso.tecnico.services.AlunoService;

@RestController
@RequestMapping("api/v1/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@PostMapping
	public ResponseEntity<ConsultaAlunoDTO> cadastrarAluno(@RequestBody @Valid RegistroAlunoDTO dto){
		
		try {
			
			Aluno aluno = alunoService.matricularAluno(AlunoMapper.fromDTO(dto));
			
			return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
	}

}
