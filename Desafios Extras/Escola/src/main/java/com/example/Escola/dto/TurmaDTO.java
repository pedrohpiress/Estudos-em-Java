package com.example.Escola.dto;

import com.example.Escola.Class.Turma;

import java.util.List;

public class TurmaDTO {
    private String nomeTurma;
    private Integer professorId;
    private List<Integer> alunoIds;

    public TurmaDTO() {
    }

    public TurmaDTO(Turma turmaAtualizada) {}

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public List<Integer> getAlunoIds() {
        return alunoIds;
    }

    public void setAlunoIds(List<Integer> alunoIds) {
        this.alunoIds = alunoIds;
    }
}
