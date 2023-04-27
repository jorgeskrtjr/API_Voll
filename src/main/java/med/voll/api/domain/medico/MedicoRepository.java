package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
     Page<Medico> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
SELECT m.id
FROM Medico m
WHERE
m.ativo = true
AND
m.especialidade = :especialidade
AND
m.id NOT IN (
  SELECT c.medico FROM Consulta c
  WHERE c.data = :data

)
ORDER BY RANDOM()
LIMIT 1

                """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query("""
           select m.ativo
           from Medico m
           where 
           m.id = :id
          """)
    Boolean findAtivoById(Long id);
}
