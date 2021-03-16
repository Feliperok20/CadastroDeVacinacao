package com.vactrole.cadastroapi.services.interfaces.vacina;

import com.vactrole.cadastroapi.errors.usuario.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroVacina;

import java.util.List;

public interface CadastroService {

    CadastroVacina insert (CadastroVacina obj)throws CadastroNotFoundException;

    List<CadastroVacina> getAllCadastro() throws CadastroNotFoundException;

    void deletCadastroById(Long id) throws CadastroNotFoundException;

    CadastroVacina updateCadastro(CadastroVacina usuario) throws CadastroNotFoundException;

    CadastroVacina find (Long id) throws CadastroNotFoundException;
}
