package com.mercadolibre.demo.impl;

import com.mercadolibre.demo.service.QuasarServiceInterface;
import com.mercadolibre.demo.usecase.UseCaseCalculateCoordinates;
import com.mercadolibre.demo.usecase.UseCaseGenerateMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuasarServiceImpl implements QuasarServiceInterface {

    @Autowired
    private UseCaseCalculateCoordinates useCaseCalculateCoordinates;

    @Autowired
    private UseCaseGenerateMessage useCaseGenerateMessage;

    /**
     * METODO FIRMA DE LOCALIZACION
     * input: distancia al emisor tal cual se recibe en cada satélite
     * output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
     *
     * @param distances
     * @return COORDENADAS (X , Y) DEL CALCULO DE LA POSICION DE LA NAVE
     */
    public Double[] GetLocation(final Double... distances) {
        return useCaseCalculateCoordinates.definePositionSatellitesByDistance(distances);
    }

    /**
     * METODO FIRMA QUE PERMITE GENERAR EL MENSAJE FINAL
     *
     * @param messages
     * @return
     */
    public String GetMessage(List<String[]> messages) {
        return useCaseGenerateMessage.generateMessage(messages);
    }
}