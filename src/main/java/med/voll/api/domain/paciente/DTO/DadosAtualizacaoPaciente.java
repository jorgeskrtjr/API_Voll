package med.voll.api.domain.paciente.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(@NotNull Long id, String nome, String cpf) {

}
