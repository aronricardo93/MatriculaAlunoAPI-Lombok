package com.curso.tecnico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.tecnico.models.Aluno;
import com.curso.tecnico.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public Aluno buscarAluno(Long id){
		Optional<Aluno> optional = alunoRepository.findById(id);
		
		return optional.orElseThrow();
	}
	
	public Page<Aluno> listarAlunos(Pageable pageable){
		return alunoRepository.findAll(pageable);
	}
	
	public Aluno matricularAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizarMatriculaAluno(Aluno aluno, Long id) {
		Aluno alunoOriginal = this.buscarAluno(id);
		
		aluno.setId(alunoOriginal.getId());
		
		return alunoRepository.save(aluno);
	}
	
	public void excluirAluno(Long id) {
		Aluno alunoOriginal = this.buscarAluno(id);
		
		alunoRepository.delete(alunoOriginal);
	}
}
