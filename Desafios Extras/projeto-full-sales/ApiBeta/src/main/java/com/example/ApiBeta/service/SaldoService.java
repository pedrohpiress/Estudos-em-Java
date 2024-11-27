package com.example.ApiBeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class SaldoService {

    private static final Logger logger = LoggerFactory.getLogger(SaldoService.class);

    @Autowired
    private RestTemplate restTemplate;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final String[] CLIENTES = { "cliente1", "cliente2", "cliente3", "cliente4" };

    public void consultarSaldosDeClientes() {
        for (String clienteId : CLIENTES) {
            executorService.submit(() -> {
                logger.info("Iniciando consulta de saldo para o cliente: " + clienteId + " na thread: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("Thread interrompida: " + Thread.currentThread().getName(), e);
                }

                consultarSaldoCliente(clienteId);
            });
        }
    }

    private void consultarSaldoCliente(String clienteId) {
        String url = "http://localhost:8080/consultarSaldo/" + clienteId;

        try {
            ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Saldo do cliente " + clienteId + ": " + response.getBody());
            } else {
                logger.warn("Saldo não encontrado para o cliente " + clienteId);
            }
        } catch (Exception e) {
            logger.error("Erro ao consultar o saldo do cliente " + clienteId, e);
        }
    }

    public void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
