package com.example.Escola.controller;

import com.example.Escola.Class.Professor;
import com.example.Escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class TesteController {

    @Autowired
    private EscolaService service;

    @PostMapping
    public ResponseEntity<Professor> adicionarProfessor(@RequestBody @Validated Professor professor) {
        Professor novoProfessor = service.adicionarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> obterProfessores() {
        List<Professor> professores = service.obterProfessores();
        return ResponseEntity.ok(professores);
    }

}