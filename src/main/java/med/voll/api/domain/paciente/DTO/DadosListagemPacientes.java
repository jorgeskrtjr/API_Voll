package med.voll.api.domain.paciente.DTO;

import med.voll.api.domain.paciente.Paciente;

public record DadosListagemPacientes(Long id, String nome, String email, String cpf, String telefone) {

    public DadosListagemPacientes(Paciente paciente){
       this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
