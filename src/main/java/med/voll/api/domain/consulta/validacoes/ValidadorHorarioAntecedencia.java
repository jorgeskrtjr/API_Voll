package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DTO.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsultas{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var dataAgora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(dataAgora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){throw new ValidacaoException("Não é possível agendar 30 minutos antes");
        }

    }

}
