package com.example.Kypchange.controller;

import com.example.Kypchange.model.Usuario;
import com.example.Kypchange.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Map<String, String> requestBody) {
        String nome = requestBody.get("nome");
        if (nome == null || nome.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Usuario novoUsuario = usuarioService.criarUsuario(nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
