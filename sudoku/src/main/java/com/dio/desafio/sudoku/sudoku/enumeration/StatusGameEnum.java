package com.dio.desafio.sudoku.sudoku.enumeration;

public enum StatusGameEnum {
    NO_STARTED("Não iniciado"),
    IN_PROGRESS("Em progresso"),
    COMPLETED("Completo"),
    FAILED("Falhou");

    private String description;

    StatusGameEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
