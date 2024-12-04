package com.example.Escola.service;

import com.example.Escola.Class.Aluno;
import com.example.Escola.Class.Professor;
import com.example.Escola.Class.Turma;
import com.example.Escola.repository.AlunoRepository;
import com.example.Escola.repository.ProfessorRepository;
import com.example.Escola.repository.TurmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Professor> obterProfessores() {
        return professorRepository.findAll();
    }

    public List<Aluno> obterAlunos() {
        return alunoRepository.findAll();
    }

    public List<Turma> obterTurma() {
        return turmaRepository.turmasComAlunos();
    }

    public Optional<Turma> obterTurmaPorId(Integer id) {
        return turmaRepository.findById(id);
    }

    public Aluno adicionarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Turma adicionarOuAtualizarTurma(Turma turma, Professor professor, List<Aluno> alunos) {
        if (turma.getIdTurma() != 0 && turmaRepository.existsById(turma.getIdTurma())) {
            turma.setProfessor(professor);
            turma.getAlunos().clear();
            turma.getAlunos().addAll(alunos);
        } else {
            turma.setProfessor(professor);
            turma.getAlunos().addAll(alunos);
        }
        return turmaRepository.save(turma);
    }

    public Professor adicionarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Turma adicionarTurma(Turma turma, Professor professor, List<Aluno> alunos) {
        turma.setProfessor(professor);
        turma.getAlunos().addAll(alunos);
        return turmaRepository.save(turma);
    }

    public Turma adicionarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletarTurma(Integer id) {
        turmaRepository.deleteById(id);
    }

    public boolean deletarProfessor(Integer id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void removerAluno(Integer alunoId) {
        alunoRepository.deleteById(alunoId);
    }

    public Turma desassociarAlunoDaTurma(Integer turmaId, Integer alunoId) {
        Turma turma = turmaRepository.findByIdWithAlunos(turmaId);
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        turma.getAlunos().remove(aluno);
        turmaRepository.save(turma);

        return turma;
    }

    public Turma removerAlunoDaTurma(Integer turmaId, Integer alunoId) {
        Turma turma = turmaRepository.findByIdWithAlunos(turmaId);
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        turma.getAlunos().remove(aluno);
        return turmaRepository.save(turma);
    }

}
