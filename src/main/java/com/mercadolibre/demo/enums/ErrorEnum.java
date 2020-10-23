package com.mercadolibre.demo.enums;

/**
 * <p>
 * ENUM DONDE SE GUARDAN LOS POSIBLES ERORRES RESPECTO A LA LOGICA
 * </p>
 */
public enum ErrorEnum {
    ERROR_MESSAGE("No hay suficiente información."),
    ERROR_INSUFFICIENT_INFORMATION_FOR_CALCULATE("No hay suficiente información para calcular position."),
    WRONG_MESSAGE("Mensaje erroneo");

    private final String id;

    ErrorEnum(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
