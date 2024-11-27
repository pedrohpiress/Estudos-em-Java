package com.example.ApiBeta;

import com.example.ApiBeta.model.SaldoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SaldoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConsultarSaldoEndpointConcorrente() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    String saldoRequestJson = "{\"clienteId\":1, \"valorConsulta\":100.0}";
                    mockMvc.perform(post("/apiBeta/saldo")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(saldoRequestJson))
                            .andExpect(status().isOk());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
    }
}

