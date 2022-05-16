package com.curso.tecnico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Aluno> listarAlunos(){
		return alunoRepository.findAll();
	}
	
	public Aluno matricularAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizarrMatriculaAluno(Aluno aluno, Long id) {
		Aluno alunoOriginal = this.buscarAluno(id);
		
		aluno.setId(alunoOriginal.getId());
		
		return alunoRepository.save(aluno);
	}
	
	public void excluirAluno(Long id) {
		Aluno alunoOriginal = this.buscarAluno(id);
		
		alunoRepository.deleteById(id);
	}
}
