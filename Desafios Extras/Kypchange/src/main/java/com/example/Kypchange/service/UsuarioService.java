package com.example.Kypchange.service;

import com.example.Kypchange.model.Usuario;
import com.example.Kypchange.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(String nome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        return usuarioRepository.save(usuario);
    }



}
