package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {

    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado enviador;

    @Scheduled(cron = "0 23 14 * * *")
    public void envioEmailsAgendado() throws ExecutionException, InterruptedException {
        var estoqueZerado = relatorioService.infoEstoque();
        var faturamentoObtido = relatorioService.faturamentoObtido();

        CompletableFuture.allOf(estoqueZerado, faturamentoObtido).join();

        enviador.enviar(estoqueZerado.get(), faturamentoObtido.get());
        System.out.println("Thread do agendamento " + Thread.currentThread().getName());
    }

}
