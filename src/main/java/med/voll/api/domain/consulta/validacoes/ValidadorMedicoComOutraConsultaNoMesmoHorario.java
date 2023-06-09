package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultRepository;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsultas {

     @Autowired
     private ConsultRepository repository;

     public void validar(DadosAgendamentoConsulta dados){

         var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

         if(medicoPossuiOutraConsultaNoMesmoHorario){
             throw new ValidacaoException("Medico ja possui outra consulta no mesmo horario");
         }

     }
}
