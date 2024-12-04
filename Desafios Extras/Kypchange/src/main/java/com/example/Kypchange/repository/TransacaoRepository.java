package com.example.Kypchange.repository;

import com.example.Kypchange.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByUsuario_Id(Long usuarioId);
}
