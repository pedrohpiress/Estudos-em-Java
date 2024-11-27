package com.example.ApiBeta.repository;

import com.example.ApiBeta.model.SaldoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaldoConsultaRepository extends JpaRepository<SaldoConsulta, Long> {
    List<SaldoConsulta> findByClienteId(Long clienteId);
}

