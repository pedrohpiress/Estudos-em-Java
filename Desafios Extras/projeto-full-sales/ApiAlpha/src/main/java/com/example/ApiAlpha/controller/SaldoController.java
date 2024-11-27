package com.example.ApiAlpha.controller;


import com.example.ApiAlpha.model.Cliente;
import com.example.ApiAlpha.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class SaldoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/consultarSaldo/{clienteId}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable String clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.getSaldo());
    }
}

