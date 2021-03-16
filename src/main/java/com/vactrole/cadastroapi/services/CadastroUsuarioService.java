package com.vactrole.cadastroapi.services;

import com.vactrole.cadastroapi.errors.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroUsuario;
import com.vactrole.cadastroapi.repositories.CadastroUsuarioRepository;
import com.vactrole.cadastroapi.services.interfaces.usuario.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroUsuarioService implements CadastroService {

    @Autowired
    private CadastroUsuarioRepository repository;

    @Override
    public CadastroUsuario find(Long id) throws CadastroNotFoundException {
        Optional<CadastroUsuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new CadastroNotFoundException(
                "Cadastro não encontrado! Id:" + id + ", Tipo" + CadastroUsuario.class.getName()));
    }

    @Override
    public CadastroUsuario insert(CadastroUsuario obj) throws CadastroNotFoundException {
        return repository.save(obj);
    }

    @Override
    public List<CadastroUsuario> getAllCadastro() throws CadastroNotFoundException {
        List<CadastroUsuario> usuarios = repository.findAll();
        if(usuarios.isEmpty()) {
            throw new CadastroNotFoundException("Nenhum cadastro encontrada");
        }
        return usuarios;
    }

    @Override
    public void deletCadastroById(Long id) throws CadastroNotFoundException {
            repository.deleteById(id);
    }
    @Override
    public CadastroUsuario updateCadastro(CadastroUsuario obj) throws CadastroNotFoundException {
        find(obj.getId());
        return repository.save(obj);
    }
}
