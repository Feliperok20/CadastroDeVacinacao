package com.vactrole.cadastroapi.errors.vacina;

public class CadastroNotFoundException extends RuntimeException{

    public CadastroNotFoundException(String cadastroVacina){
        super(cadastroVacina);
    }

    public CadastroNotFoundException(String cadastroVacina, Throwable cause){
        super (cadastroVacina, cause);
    }
}
