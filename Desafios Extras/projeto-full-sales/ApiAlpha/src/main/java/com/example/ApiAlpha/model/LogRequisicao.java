package com.example.ApiAlpha.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs_requisicoes")
public class LogRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "data_requisicao")
    private LocalDateTime dataRequisicao;

    @Column(name = "status_resposta")
    private String statusResposta;

    @Column(name = "mensagem_resposta")
    private String mensagemResposta;

    public LogRequisicao() {}

    public LogRequisicao(Long clienteId, String statusResposta, String mensagemResposta) {
        this.clienteId = clienteId;
        this.dataRequisicao = LocalDateTime.now();
        this.statusResposta = statusResposta;
        this.mensagemResposta = mensagemResposta;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(LocalDateTime dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getStatusResposta() {
        return statusResposta;
    }

    public void setStatusResposta(String statusResposta) {
        this.statusResposta = statusResposta;
    }

    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public void setMensagemResposta(String mensagemResposta) {
        this.mensagemResposta = mensagemResposta;
    }
}

