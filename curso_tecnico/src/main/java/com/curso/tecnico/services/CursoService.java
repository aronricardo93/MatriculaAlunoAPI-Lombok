package com.curso.tecnico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.tecnico.models.Curso;
import com.curso.tecnico.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Page<Curso> listarCursos(Pageable pageable){
		return cursoRepository.findAll(pageable);
	}
	
	public Curso buscarCurso(Long id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		
		return optional.orElseThrow();
	}
	
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso atualizarCurso(Curso curso, Long id) {
		Curso cursoOriginal = this.buscarCurso(id);
		
		curso.setId(cursoOriginal.getId());
		
		return cursoRepository.save(curso);
	}
	
	public void excluirCurso(Long id) {
		Curso cursoOriginal = this.buscarCurso(id);
		
		cursoRepository.delete(cursoOriginal);
	}
}
