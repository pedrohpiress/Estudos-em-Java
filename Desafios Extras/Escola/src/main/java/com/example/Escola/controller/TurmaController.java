package com.example.Escola.controller;

import com.example.Escola.Class.Aluno;
import com.example.Escola.Class.Professor;
import com.example.Escola.Class.Turma;
import com.example.Escola.repository.AlunoRepository;
import com.example.Escola.repository.ProfessorRepository;
import com.example.Escola.repository.TurmaRepository;
import com.example.Escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/escola")
public class EscolaController {

    @Autowired
    private EscolaService service;

    @GetMapping("/teste")
    public String teste() {
        return "Ta no ar";
    }

//    @GetMapping("/professores")
//    public List<Professor> obterTodosProfessores(){
//        return service.obterProfessores();
//    }
//
//    @GetMapping("/alunos")
//    public List<Aluno> obterTodosAlunos(){
//        return service.obterAlunos();
//    }
//
//    @GetMapping("/turmas")
//    public List<Turma> obterTodaTurma(){
//        return service.obterTurma();
//    }

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.adicionarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @PostMapping("/professores")
    public ResponseEntity<Professor> adicionarProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = service.adicionarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @PostMapping("/turmas")
    public ResponseEntity<Turma> adicionarTurma(@RequestBody Turma turma,
                                                @RequestParam Integer professorId,
                                                @RequestParam List<Integer> alunoIds) {
        // Verifica se o professor existe
        Professor professor = service.obterProfessores().stream()
                .filter(p -> Objects.equals(p.getIdProfessor(), professorId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        // Verifica se os alunos existem
        List<Aluno> alunos = alunoIds.stream()
                .map(id -> service.obterAlunos().stream()
                        .filter(a -> Objects.equals(a.getIdAluno(), id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Aluno não encontrado")))
                .toList();

        // Adiciona a turma
        Turma novaTurma = service.adicionarTurma(turma, professor, alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTurma);
    }
}
