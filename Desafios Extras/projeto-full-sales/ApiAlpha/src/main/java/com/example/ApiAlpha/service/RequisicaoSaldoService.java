package com.example.ApiAlpha.service;
import com.example.ApiAlpha.model.LogRequisicao;
import com.example.ApiAlpha.model.RequisicaoSaldo;
import com.example.ApiAlpha.repository.LogRequisicaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequisicaoSaldoService {

    private final LogRequisicaoRepository logRequisicaoRepository;
    private final RestTemplate restTemplate;

    public RequisicaoSaldoService(LogRequisicaoRepository logRequisicaoRepository, RestTemplate restTemplate) {
        this.logRequisicaoRepository = logRequisicaoRepository;
        this.restTemplate = restTemplate;
    }

    public String consultarSaldo(RequisicaoSaldo requisicao) {
        String url = "http://localhost:8081/ApiBeta/saldo";

        try {
            String resposta = restTemplate.postForObject(url, requisicao, String.class);

            LogRequisicao log = new LogRequisicao(requisicao.getClienteId(), "SUCESSO", resposta);
            logRequisicaoRepository.save(log);

            return resposta;
        } catch (Exception e) {
            LogRequisicao log = new LogRequisicao(requisicao.getClienteId(), "ERRO", e.getMessage());
            logRequisicaoRepository.save(log);

            throw new RuntimeException("Erro ao consultar saldo: " + e.getMessage());
        }
    }
}
