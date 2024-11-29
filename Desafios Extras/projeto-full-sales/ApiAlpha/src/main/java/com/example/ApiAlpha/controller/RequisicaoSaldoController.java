package com.example.ApiAlpha.controller;

import com.example.ApiAlpha.model.RequisicaoSaldo;
import com.example.ApiAlpha.service.RequisicaoSaldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ApiAlpha/saldo")
public class RequisicaoSaldoController {

    private final RequisicaoSaldoService requisicaoSaldoService;

    public RequisicaoSaldoController(RequisicaoSaldoService requisicaoSaldoService) {
        this.requisicaoSaldoService = requisicaoSaldoService;
    }

    @PostMapping
    public ResponseEntity<String> consultarSaldo(@RequestBody RequisicaoSaldo requisicaoSaldo) {
        try {
            String resposta = requisicaoSaldoService.consultarSaldo(requisicaoSaldo);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
