package com.curso.tecnico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<Page<ConsultaAlunoDTO>> listarAlunos(Pageable pageable){
		try {
			return ResponseEntity.ok(alunoService.listarAlunos(pageable).map(AlunoMapper::fromEntity));
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaAlunoDTO> consultarAlunoPorId(@PathVariable Long id){
		try {
			Aluno aluno = alunoService.buscarAluno(id);
			
			return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaAlunoDTO> atualizarAluno(@PathVariable Long id, @RequestBody RegistroAlunoDTO dto){
		try {
			Aluno aluno = alunoService.atualizarMatriculaAluno(AlunoMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<ConsultaAlunoDTO> cadastrarAluno(@RequestBody @Valid RegistroAlunoDTO dto){
		
		try {
			
			Aluno aluno = alunoService.matricularAluno(AlunoMapper.fromDTO(dto));
			
			return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaAlunoDTO> deletarAluno(@PathVariable Long id){
		try {
			alunoService.excluirAluno(id);
			
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
