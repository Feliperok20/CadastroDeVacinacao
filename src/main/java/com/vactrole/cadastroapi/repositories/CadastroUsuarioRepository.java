package com.vactrole.cadastroapi.repositories;

import com.vactrole.cadastroapi.models.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, Long> {
}
