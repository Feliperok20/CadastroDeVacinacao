package com.vactrole.cadastroapi.services.interfaces.usuario;

import com.vactrole.cadastroapi.errors.usuario.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroUsuario;

import java.util.List;

public interface CadastroService {

    CadastroUsuario insert (CadastroUsuario obj)throws CadastroNotFoundException;

    List<CadastroUsuario> getAllCadastro() throws CadastroNotFoundException;

    void deletCadastroById(Long id) throws CadastroNotFoundException;

    CadastroUsuario updateCadastro(CadastroUsuario usuario) throws CadastroNotFoundException;

    CadastroUsuario find (Long id) throws CadastroNotFoundException;
}
