package com.mercadolibre.demo.service;

import java.util.List;

public interface QuasarServiceInterface {
    /**
     * METODO QUE PERMITE OBTENER LAS COORDENADAS DE LA NAVE DADO UNA DISTANCIA
     *
     * @param distances
     * @return Double[]
     */
    Double[] getLocation(final Double... distances);

    /**
     * METODO QUE PERMITE OBTENER EL MENSAJE DESFASADO
     *
     * @param messages
     * @return String
     */
    String getMessage(List<String[]> messages);

}
