package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultRepository;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

     private ConsultRepository repository;

     public void validar(DadosAgendamentoConsulta dados){

         var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

         if(medicoPossuiOutraConsultaNoMesmoHorario){
             throw new ValidacaoException("Medico ja possui outra consulta no mesmo horario");
         }

     }
}
