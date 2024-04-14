package com.flexx.register.model.enums;

public enum DocumentType {

    CPF("CPF"),
    CNPJ("CNPJ");

    DocumentType(String documentType) {
        this.value = documentType;
    }

    private final String value;

    public String getValue() {
        return value;
    }

}
