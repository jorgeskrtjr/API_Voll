package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController{

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente paciente){
        repository.save(new Paciente(paciente));
    }
    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPacientes::new);
    }

}
