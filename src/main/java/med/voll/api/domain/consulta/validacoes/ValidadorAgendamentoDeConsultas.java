package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DTO.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {

    void validar(DadosAgendamentoConsulta dados);
}
