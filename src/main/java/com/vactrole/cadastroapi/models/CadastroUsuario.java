package com.vactrole.cadastroapi.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;


@Entity
public class CadastroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String data;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF(message = "CPF inválido")
    @Column(unique = true)
    private String cpf;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "usuario")
    private List<CadastroVacina> vacina;

    public Long getId() {
        return id;
    }

    public CadastroUsuario() {

    }

    public CadastroUsuario(String name, String data, String email, String cpf) {

        this.name = name;
        this.data = data;
        this.email = email;
        this.cpf = cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastroUsuario that = (CadastroUsuario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
