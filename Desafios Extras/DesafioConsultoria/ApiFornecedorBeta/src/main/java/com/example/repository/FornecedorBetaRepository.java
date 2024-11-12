package com.example.repository;

import com.example.model.FornecedorBeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FornecedorBetaRepository extends JpaRepository<FornecedorBeta, Long> {
    Optional<FornecedorBeta> findByNomeProduto(@Param("nomeProduto") String nome);
}
