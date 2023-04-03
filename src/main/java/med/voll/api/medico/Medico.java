package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import  med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco Endereco;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.Endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.dadosEndereco() != null){
            this.Endereco.atualizarInformacoes(dados.dadosEndereco());
        }

    }
}