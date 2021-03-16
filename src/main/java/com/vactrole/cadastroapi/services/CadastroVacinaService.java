package com.vactrole.cadastroapi.services;

import com.vactrole.cadastroapi.errors.vacina.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroUsuario;
import com.vactrole.cadastroapi.models.CadastroVacina;
import com.vactrole.cadastroapi.repositories.CadastroVacinaRepository;
import com.vactrole.cadastroapi.services.interfaces.vacina.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroVacinaService implements CadastroService {

    @Autowired
    private CadastroVacinaRepository repository;

    @Override
    public CadastroVacina find(Long id) throws CadastroNotFoundException {
        Optional<CadastroVacina> obj = repository.findById(id);
        return obj.orElseThrow(() -> new CadastroNotFoundException(
                "Cadastro não encontrado! Id:" + id + ", Tipo" + CadastroVacina.class.getName()));
    }
    @Override
    public CadastroVacina insert(CadastroVacina obj) throws CadastroNotFoundException {
        return repository.save(obj);
    }

    @Override
    public List<CadastroVacina> getAllCadastro() throws CadastroNotFoundException {
        List<CadastroVacina> vacinas = repository.findAll();
        if(vacinas.isEmpty()) {
            throw new CadastroNotFoundException("Nenhum cadastro encontrada");
        }
        return vacinas;
    }

    @Override
    public void deletCadastroById(Long id) throws CadastroNotFoundException {
        repository.deleteById(id);
    }

    @Override
    public CadastroVacina updateCadastro(CadastroVacina obj) throws CadastroNotFoundException {
        find(obj.getId());
        return repository.save(obj);
    }
}

