package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.enums.ErrorEnum;
import com.mercadolibre.demo.misc.UtilSatellites;
import com.mercadolibre.demo.model.*;
import com.mercadolibre.demo.service.QuasarServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping
@Slf4j
public class QuasarControllerDemo {

    @Autowired
    private QuasarServiceInterface quasarServiceInterface;

    /**
     * METODO POSTMAPPING CONTROLLER QUE REDIRIJE LA FUNCIONALIDAD PARA CALCULAR LA POSITION DE LA NAVE
     *
     * @param request
     * @return
     */
    @PostMapping(path = "/topsecret", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> triangulatePosition(@RequestBody final QuasarSatellitesRequest request) {

        Double[] distance = quasarServiceInterface.GetLocation(UtilSatellites.obtainDistances(request));
        String message = quasarServiceInterface.GetMessage(UtilSatellites.obtainMessages(request));
        CoordinatesResponse position = new CoordinatesResponse();
        position.setX(distance[0]);
        position.setY(distance[1]);
        PositionResponse answerPosition = new PositionResponse();
        answerPosition.setPosition(position);
        answerPosition.setMessage(message);
        return ResponseEntity.ok(answerPosition);
    }

    /**
     * METODO RequestMapping CONTROLLER QUE REDIRIJE LA FUNCIONALIDAD PARA CALCULAR LA POSITION DE LA NAVE CON EL
     * DE UN SATELITE COMO PARAMETRO RECIBIDO POR (POST O GET)
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/topsecret_split", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Object> splitPosition(@RequestBody final QuasarSplitRequest request,
                                                @RequestParam(value = "satellite_name", required = false) final String satelliteName) {
        request.setName(satelliteName);
        PositionResponse answerPosition = new PositionResponse();
        Double[] distance = null;
        String message = ErrorEnum.ERROR_MESSAGE.getId();
        if (UtilSatellites.verifyNameSatellite(request.getName())) {
            QuasarSatellitesRequest quasarSatellitesRequest = QuasarSatellitesRequest.builder().satellites(
                    Arrays.asList(Satellite.builder()
                            .distance(Double.valueOf(request.getDistance()))
                            .message(request.getMessage())
                            .name(request.getName())
                            .build())).build();
            distance = quasarServiceInterface.GetLocation(UtilSatellites.obtainDistances(quasarSatellitesRequest));
        } else {
            throw new RuntimeException(ErrorEnum.WRONG_MESSAGE.getId());
        }
        CoordinatesResponse position = new CoordinatesResponse();
        position.setX(distance[0]);
        position.setY(distance[1]);
        answerPosition.setPosition(position);
        answerPosition.setMessage(message);
        return ResponseEntity.ok(answerPosition);
    }

}
