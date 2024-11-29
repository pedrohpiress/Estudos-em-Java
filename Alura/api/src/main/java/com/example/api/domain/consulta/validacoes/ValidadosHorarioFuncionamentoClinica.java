package com.example.api.domain.consulta.validacoes;

import com.example.api.domain.ValidacaoException;
import com.example.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadosHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDabertura = dataConsulta.getHour() < 7;
        var depoisDoEncerramento = dataConsulta.getHour() > 18;

        if (domingo || antesDabertura || depoisDoEncerramento){
            throw new ValidacaoException("Consulta fora do horário e/ou dia de funcionamento da clínica");
        }
    }

}
