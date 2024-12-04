    package com.example.Escola.Class;

    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "turma")
    public class Turma {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idTurma;
        private String nomeTurma;

        @ManyToOne
        @JoinColumn(name = "professor_id", nullable = false)
        private Professor professor;

        @ManyToMany
        @JoinTable(
                name = "turma_aluno",
                joinColumns = @JoinColumn(name = "turma_id"),
                inverseJoinColumns = @JoinColumn(name = "aluno_id"))
        private List<Aluno> alunos;

        public Turma() {}

        public String getNomeTurma() {
            return nomeTurma;
        }

        public void setNomeTurma(String nomeTurma) {
            this.nomeTurma = nomeTurma;
        }

        public Professor getProfessor() {
            return professor;
        }

        public List<Aluno> getAlunos() {
            return alunos;
        }

        public void setAlunos(List<Aluno> alunos) {
            this.alunos = alunos;
        }

        public void adicionarAluno(Aluno aluno) {
            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
                if (!aluno.getTurmas().contains(this)) {
                    aluno.adicionarTurma(this);
                }
            }
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public int getIdTurma() {
            return idTurma;
        }
    }

