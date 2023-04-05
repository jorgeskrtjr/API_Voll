package med.voll.api.medico.DTO;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getEspecialidade(), medico.getEndereco());
    }


}
