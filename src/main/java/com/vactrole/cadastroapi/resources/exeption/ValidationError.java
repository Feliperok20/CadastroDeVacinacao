package com.vactrole.cadastroapi.resources.exeption;

import java.util.ArrayList;
import java.util.List;

public class ValidationError  extends StandardError{

    private List<FieldMessage> list = new ArrayList<>();

    public ValidationError(Integer status, String msg) {
        super(status, msg);
    }

    public List<FieldMessage> getError() {
        return list;
    }

    public void addError(String fieldName, String messagem) {
        list.add(new FieldMessage(fieldName, messagem));
    }
}
