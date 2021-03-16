package com.vactrole.cadastroapi.repositories;

import com.vactrole.cadastroapi.models.CadastroVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CadastroVacinaRepository extends JpaRepository<CadastroVacina, Long> {
}
