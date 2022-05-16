package com.curso.tecnico.controllers;

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

import com.curso.tecnico.dtos.curso.ConsultaCursoDTO;
import com.curso.tecnico.dtos.curso.CursoMapper;
import com.curso.tecnico.dtos.curso.RegistroCursoDTO;
import com.curso.tecnico.models.Curso;
import com.curso.tecnico.services.CursoService;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<Page<ConsultaCursoDTO>> listarCursos(Pageable pageable){
		try {
			return ResponseEntity.ok(cursoService.listarCursos(pageable).map(CursoMapper::fromEntity));
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaCursoDTO> consultarCursoPorId(@PathVariable Long id){
		try {
			Curso curso = cursoService.buscarCurso(id);
			
			return ResponseEntity.ok(CursoMapper.fromEntity(curso));
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaCursoDTO> atualizarCurso(@PathVariable Long id, @RequestBody RegistroCursoDTO dto){
		try {
			Curso curso= cursoService.atualizarCurso(CursoMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(CursoMapper.fromEntity(curso));
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<ConsultaCursoDTO> cadastrarCurso(@RequestBody RegistroCursoDTO dto){
		
		try {
			
			Curso curso = cursoService.salvarCurso(CursoMapper.fromDTO(dto));
			
			return ResponseEntity.ok(CursoMapper.fromEntity(curso));
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaCursoDTO> excluirCurso(@PathVariable Long id){
		try {
			cursoService.excluirCurso(id);
			
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
