package com.vactrole.cadastroapi.errors;

public class CadastroNotFoundException extends RuntimeException{

    public CadastroNotFoundException(String cadastro){
        super(cadastro);
    }

    public CadastroNotFoundException(String cadastro, Throwable cause){
        super (cadastro, cause);
    }
}
