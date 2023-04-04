package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    private Endereco endereco;

    private Boolean ativo;


    public Paciente(DadosCadastroPaciente paciente){
        this.ativo = true;
        this.cpf = paciente.cpf();
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.telefone = paciente.telefone();
        this.endereco = new Endereco(paciente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
