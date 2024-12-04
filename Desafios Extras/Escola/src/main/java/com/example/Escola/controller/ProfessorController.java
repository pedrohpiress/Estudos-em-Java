package com.example.Escola.controller;

import com.example.Escola.Class.Professor;
import com.example.Escola.dto.ProfessorDTO;
import com.example.Escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private EscolaService service;

    @PostMapping
    public ResponseEntity<Professor> adicionarProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setSalario(professorDTO.getSalario());
        Professor novoProfessor = service.adicionarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> obterProfessores() {
        List<Professor> professores = service.obterProfessores();
        return ResponseEntity.ok(professores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable Integer id, @RequestBody ProfessorDTO professorDTO) {
        Optional<Professor> professorOpt = service.obterProfessores().stream()
                .filter(p -> Objects.equals(p.getIdProfessor(), id))
                .findFirst();

        if (professorOpt.isPresent()) {
            Professor professor = professorOpt.get();
            professor.setNome(professorDTO.getNome());
            professor.setSalario(professorDTO.getSalario());

            Professor professorAtualizado = service.adicionarProfessor(professor);
            return ResponseEntity.ok(professorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Integer id) {
        if (service.deletarProfessor(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}