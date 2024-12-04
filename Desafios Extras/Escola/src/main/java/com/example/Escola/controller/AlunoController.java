package com.example.Escola.controller;

import com.example.Escola.Class.Aluno;
import com.example.Escola.Class.Turma;
import com.example.Escola.dto.AlunoDTO;
import com.example.Escola.dto.TurmaDTO;
import com.example.Escola.repository.AlunoRepository;
import com.example.Escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private EscolaService service;
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        Aluno novoAluno = service.adicionarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> obterAluno(){
        List<Aluno> alunos = service.obterAlunos();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Integer id, @RequestBody AlunoDTO alunoDTO) {
        Optional<Aluno> alunoOpt = service.obterAlunos().stream()
                .filter(a -> Objects.equals(a.getIdAluno(), id))
                .findFirst();

        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            aluno.setNome(alunoDTO.getNome());

            Aluno alunoAtualizado = service.adicionarAluno(aluno);
            return ResponseEntity.ok(alunoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{turmaId}/alunos/{alunoId}")
    public ResponseEntity<TurmaDTO> removerAluno(@PathVariable Integer turmaId, @PathVariable Integer alunoId) {
        Turma turmaAtualizada = service.removerAlunoDaTurma(turmaId, alunoId);
        return ResponseEntity.ok(new TurmaDTO(turmaAtualizada));
    }

}
