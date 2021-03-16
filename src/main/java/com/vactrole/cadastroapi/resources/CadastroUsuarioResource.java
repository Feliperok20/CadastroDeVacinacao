package com.vactrole.cadastroapi.resources;

import com.vactrole.cadastroapi.errors.CadastroNotFoundException;
import com.vactrole.cadastroapi.models.CadastroUsuario;
import com.vactrole.cadastroapi.services.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/cadastroUsuario")
public class CadastroUsuarioResource {

    @Autowired
    private CadastroUsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        CadastroUsuario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody CadastroUsuario obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCadastro(@PathVariable Long id) throws CadastroNotFoundException{
        service.deletCadastroById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody CadastroUsuario obj, @PathVariable Long id) {
        obj = service.updateCadastro(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllMessages() {
        try {
            return ResponseEntity.ok(service.getAllCadastro());
        } catch (CadastroNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
