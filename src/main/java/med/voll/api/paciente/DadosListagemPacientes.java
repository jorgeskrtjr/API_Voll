package med.voll.api.paciente;

import med.voll.api.paciente.Paciente;

public record DadosListagemPacientes(Long id, String nome, String email, String cpf, String telefone) {

    public DadosListagemPacientes(Paciente paciente){
       this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
