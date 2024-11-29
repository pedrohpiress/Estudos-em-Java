package com.example.repository;

import com.example.model.FornecedorAlfa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FornecedorAlfaRepository extends JpaRepository<FornecedorAlfa, Long> {
    Optional<FornecedorAlfa> findByNomeProduto(@Param("nomeProduto") String nome);
}
