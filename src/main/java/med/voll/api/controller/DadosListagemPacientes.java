package med.voll.api.controller;

import med.voll.api.paciente.Paciente;

public record DadosListagemPacientes(String nome, String email, String cpf, String telefone) {

    public DadosListagemPacientes(Paciente paciente){
       this(paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }
}
