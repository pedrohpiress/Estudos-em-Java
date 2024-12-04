package com.example.Escola.repository;

import com.example.Escola.Class.Turma;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    @Query("SELECT t FROM Turma t LEFT JOIN FETCH t.professor LEFT JOIN FETCH t.alunos")
    List<Turma> turmasComAlunos();

    @Query("SELECT t FROM Turma t LEFT JOIN t.alunos a WHERE a.id = :alunoId")
    List<Turma> findTurmasByAlunoId(Integer alunoId);

    @Modifying
    @Transactional
    @Query("DELETE FROM TurmaAluno ta WHERE ta.aluno.id = :alunoId")
    void removerAlunoDasTurmas(@Param("alunoId") Integer alunoId);

    @Query("SELECT t FROM Turma t LEFT JOIN FETCH t.alunos WHERE t.id = :id")
    Turma findByIdWithAlunos(@Param("id") Integer id);
}
