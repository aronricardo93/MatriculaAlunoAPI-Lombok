package com.curso.tecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.tecnico.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
