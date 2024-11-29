package com.example.api.domain.consulta.validacoes;

import com.example.api.domain.ValidacaoException;
import com.example.api.domain.consulta.DadosAgendamentoConsulta;
import com.example.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadosMedicoAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = medicoRepository.findByAtivoById(dados.idMedico());

        if (!medicoEstaAtivo){
            throw new ValidacaoException("Médico não está ativo");
        }
    }
}
