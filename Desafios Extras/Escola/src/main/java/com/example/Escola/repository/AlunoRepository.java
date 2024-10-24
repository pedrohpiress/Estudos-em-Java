package com.example.Escola.repository;

import com.example.Escola.Class.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByNome
}
