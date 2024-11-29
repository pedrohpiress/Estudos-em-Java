package com.example.api.domain.consulta.validacoes;

import com.example.api.domain.ValidacaoException;
import com.example.api.domain.consulta.ConsultaRepository;
import com.example.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadosPacienteNaMesmaData implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (!pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Ja possui um paciente com uma consulta neste horário");
        }

    }

}
