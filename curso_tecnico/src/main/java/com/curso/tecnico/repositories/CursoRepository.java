package com.curso.tecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.tecnico.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
