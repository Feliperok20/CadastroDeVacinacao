package com.vactrole.cadastroapi.resources;



import com.vactrole.cadastroapi.errors.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroVacina;
import com.vactrole.cadastroapi.services.CadastroVacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/cadastroVacina")
public class CadastroVacinaResource {

    @Autowired
    private CadastroVacinaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        CadastroVacina obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody CadastroVacina obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCadastro(@PathVariable Long id) throws CadastroNotFoundException {
        service.deletCadastroById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<?> update (@RequestBody CadastroVacina obj, @PathVariable Long id) {
        obj = service.updateCadastro(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllCadastors() {
        try {
            return ResponseEntity.ok(service.getAllCadastro());
        } catch (CadastroNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}