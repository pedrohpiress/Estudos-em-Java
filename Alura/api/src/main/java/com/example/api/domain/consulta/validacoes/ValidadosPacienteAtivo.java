package com.example.api.domain.consulta.validacoes;

import com.example.api.domain.ValidacaoException;
import com.example.api.domain.consulta.DadosAgendamentoConsulta;
import com.example.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadosPacienteAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = pacienteRepository.findByAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com pacientes inativos");
        }
    }

}
