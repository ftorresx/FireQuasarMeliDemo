package com.mercadolibre.demo.impl;

import com.mercadolibre.demo.enums.ErrorEnum;
import com.mercadolibre.demo.service.QuasarServiceInterface;
import com.mercadolibre.demo.usecase.UseCaseCalculateCoordinates;
import com.mercadolibre.demo.usecase.UseCaseGenerateMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class QuasarServiceImpl implements QuasarServiceInterface {
    private final Double coordinateXSatelliteKenobi = -500.00;
    private final Double coordinateYSatelliteKenobi = -200.00;

    private final Double coordinateXSatelliteSkywalker = 100.00;
    private final Double coordinateYSatelliteSkywalker = -100.00;

    private final Double coordinateXSatelliteSato = 500.00;
    private final Double coordinateYSatelliteSato = 100.00;

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
        List<Double> satelliteKenobi = Arrays.asList(coordinateXSatelliteKenobi, coordinateYSatelliteKenobi, distances[0]);
        List<Double> satelliteSkywalker = Arrays.asList(coordinateXSatelliteSkywalker, coordinateYSatelliteSkywalker, distances[1]);
        List<Double> satelliteSato = Arrays.asList(coordinateXSatelliteSato, coordinateYSatelliteSato, distances[2]);
        List<Double> range1 = useCaseCalculateCoordinates.calculateCoordinatesNave(satelliteKenobi, satelliteSkywalker);
        List<Double> range2 = useCaseCalculateCoordinates.calculateCoordinatesNave(satelliteKenobi, satelliteSato);
        List<Double> coordinatesNave = useCaseCalculateCoordinates.triangulatePosition(range1, range2);
        log.info("INFO COORDENADAS NAVE {}", coordinatesNave);

        return coordinatesNave.toArray(new Double[coordinatesNave.size()]);
    }

    /**
     * METODO FIRMA QUE PERMITE GENERAR EL MENSAJE FINAL
     *
     * @param messages
     * @return
     */
    public String GetMessage(List<String[]> messages) {
        if (messages.size() > 3 || messages.size() < 1) {
            throw new RuntimeException(ErrorEnum.WRONG_MESSAGE.getId());
        }
        return useCaseGenerateMessage.generateMessage(messages);
    }
}