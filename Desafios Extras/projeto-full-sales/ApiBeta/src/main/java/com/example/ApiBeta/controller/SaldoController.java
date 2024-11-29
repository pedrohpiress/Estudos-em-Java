package com.example.ApiBeta.controller;
import com.example.ApiBeta.service.SaldoService;
import com.example.ApiBeta.model.SaldoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ApiBeta/saldo")
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    @GetMapping("/consultarSaldos")
    public String consultarSaldos() {
        saldoService.consultarSaldosDeClientes();
        return "Consultas de saldos iniciadas!";
    }
}

