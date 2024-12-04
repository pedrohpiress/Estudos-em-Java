package com.example.Kypchange.controller;

import com.example.Kypchange.model.InvestimentoRequest;
import com.example.Kypchange.model.Transacao;
import com.example.Kypchange.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodasTransacoes() {
        List<Transacao> transacoes = transacaoService.listarTodasTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Transacao>> listarTransacoesPorUsuario(@PathVariable Long usuarioId) {
        try {
            List<Transacao> transacoes = transacaoService.listarTransacoesPorUsuario(usuarioId);
            return ResponseEntity.ok(transacoes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/converter/{usuarioId}")
    public ResponseEntity<?> converterTransacao(@PathVariable Long usuarioId, @RequestBody InvestimentoRequest request) {
        try {
            Transacao transacao = transacaoService.converterInvestimentoParaTransacao(request, "Investimento", usuarioId);
            transacaoService.salvarTransacao(transacao);
            return ResponseEntity.ok("Transação salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
