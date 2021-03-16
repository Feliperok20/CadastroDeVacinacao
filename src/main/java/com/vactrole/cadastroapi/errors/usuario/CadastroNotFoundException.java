package com.vactrole.cadastroapi.errors.usuario;

public class CadastroNotFoundException extends RuntimeException{

    public CadastroNotFoundException(String cadastroUsuario){
        super(cadastroUsuario);
    }

    public CadastroNotFoundException(String cadastroUsuario, Throwable cause){
        super (cadastroUsuario, cause);
    }
}
