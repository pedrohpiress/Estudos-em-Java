package com.example.Escola.controller;

import com.example.Escola.Class.Aluno;
import com.example.Escola.Class.Professor;
import com.example.Escola.Class.Turma;
import com.example.Escola.dto.TurmaDTO;
import com.example.Escola.repository.TurmaRepository;
import com.example.Escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private EscolaService service;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity<List<Turma>> obterTurmas() {
        List<Turma> turmas = service.obterTurma();
        return ResponseEntity.ok(turmas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Integer id) {
        List<Turma> turmaOpt = service.obterTurma();

        if (!turmaOpt.isEmpty()) {
            service.deletarTurma(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Turma> adicionarTurma(@RequestBody TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        Professor professor = service.obterProfessores().stream()
                .filter(p -> Objects.equals(p.getIdProfessor(), turmaDTO.getProfessorId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        List<Aluno> alunos = turmaDTO.getAlunoIds().stream()
                .map(id -> service.obterAlunos().stream()
                        .filter(a -> Objects.equals(a.getIdAluno(), id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado")))
                .collect(Collectors.toList());

        turma.setNomeTurma(turmaDTO.getNomeTurma());
        turma.setProfessor(professor);
        turma.getAlunos().addAll(alunos);

        Turma novaTurma = service.adicionarTurma(turma, professor, alunos);
        return ResponseEntity.ok(novaTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Integer id, @RequestBody TurmaDTO turmaDTO) {
        Optional<Turma> turmaOpt = service.obterTurmaPorId(id);

        if (turmaOpt.isPresent()) {
            Turma turma = turmaOpt.get();
            turma.setNomeTurma(turmaDTO.getNomeTurma());
            Professor professor = null;
            if (turmaDTO.getProfessorId() != null) {
                professor = service.obterProfessores().stream()
                        .filter(p -> Objects.equals(p.getIdProfessor(), turmaDTO.getProfessorId()))
                        .findFirst()
                        .orElse(null);
                turma.setProfessor(professor);
            }

            List<Aluno> alunos = null;
            if (turmaDTO.getAlunoIds() != null && !turmaDTO.getAlunoIds().isEmpty()) {
                alunos = turmaDTO.getAlunoIds().stream()
                        .map(idAluno -> service.obterAlunos().stream()
                                .filter(aluno -> Objects.equals(aluno.getIdAluno(), idAluno))
                                .findFirst()
                                .orElse(null))
                        .collect(Collectors.toList());
                turma.setAlunos(alunos);
            }

            Turma turmaAtualizada = service.adicionarOuAtualizarTurma(turma, professor, alunos);

            return ResponseEntity.ok(turmaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/remover-aluno/{alunoId}")
    public ResponseEntity<Void> removerAlunoDasTurmas(@PathVariable Integer alunoId) {
        turmaRepository.removerAlunoDasTurmas(alunoId);
        return ResponseEntity.noContent().build();
    }


}
