package com.mercadolibre.demo.misc;

import com.mercadolibre.demo.enums.NamesSatellitesEnum;
import com.mercadolibre.demo.model.MessageResponse;
import com.mercadolibre.demo.model.QuasarSatellitesRequest;
import com.mercadolibre.demo.model.Satellite;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public final class UtilSatellites {
    /**
     * METODO UTILITARIO QUE PERMITE OBTENER LAS DISTANCIAS INTERCEPTADAS EN EL REQUEST
     *
     * @param request
     * @return
     */
    public static Double[] obtainDistances(final QuasarSatellitesRequest request) {
        List<Double> distancesList = new ArrayList<>();
        for (Satellite satellite : request.getSatellites()) {
            if (satellite.getName().equalsIgnoreCase(NamesSatellitesEnum.KENOBI.name())) {
                distancesList.add(0, satellite.getDistance());
            }
            if (satellite.getName().equalsIgnoreCase(NamesSatellitesEnum.SKYWALKER.name())) {
                distancesList.add(1, satellite.getDistance());
            }
            if (satellite.getName().equalsIgnoreCase(NamesSatellitesEnum.SATO.name())) {
                distancesList.add(2, satellite.getDistance());
            }
        }
        return distancesList.toArray(new Double[distancesList.size()]);
    }

    /**
     * METODO UTILITARIO QUE PERMITE OBTENER MENSAJES INTERCEPTADOS
     *
     * @param quasarSatellitesRequest
     * @return
     */
    public static List<String[]> obtainMessages(final QuasarSatellitesRequest quasarSatellitesRequest) {
        List<String[]> messagesList = new ArrayList<>();
        for (Satellite satellite : quasarSatellitesRequest.getSatellites()) {
            messagesList.add(satellite.getMessage());
        }
        return messagesList;
    }

    /**
     * METODO UTILITARIO QUE PERMITE VERIFICAR EL NOMBRE DE UN SATELITE DADO
     *
     * @param name
     * @return
     */
    public static boolean verifyNameSatellite(final String name) {
        boolean validate = false;

        if (name.equalsIgnoreCase(NamesSatellitesEnum.KENOBI.name()) |
                name.equalsIgnoreCase(NamesSatellitesEnum.SKYWALKER.name()) |
                name.equalsIgnoreCase(NamesSatellitesEnum.SATO.name())) {
            validate = true;
        }
        return validate;
    }

    /**
     * METODO UTILITARIO QUE PERMITE MEZCLAR EL MENSAJE DADA UNA POSICION
     *
     * @param messages
     * @return
     */
    public static MessageResponse mixMessage(String[] messages, MessageResponse messageProcess) {

        for (int i = 0; i < messages.length; i++) {
            switch (i) {
                case 0:
                    if (Objects.isNull(messageProcess.getZero()) || messageProcess.getZero().equals("")) {
                        messageProcess.setZero(messages[i]);
                    }
                    break;
                case 1:
                    if (Objects.isNull(messageProcess.getOne()) || messageProcess.getOne().equals("")) {
                        messageProcess.setOne(messages[i]);
                    }
                    break;
                case 2:
                    if (Objects.isNull(messageProcess.getTwo()) || messageProcess.getTwo().equals("")) {
                        messageProcess.setTwo(messages[i]);
                    }
                    break;
                case 3:
                    if (Objects.isNull(messageProcess.getThree()) || messageProcess.getThree().equals("")) {
                        messageProcess.setThree(messages[i]);
                    }
                    break;
                case 4:
                    if (Objects.isNull(messageProcess.getFour()) || messageProcess.getFour().equals("")) {
                        messageProcess.setFour(messages[i]);
                    }
                    break;
            }
        }
        log.info("MENSAJE RETORNADO -> {}", messageProcess);
        return messageProcess;
    }

    /**
     * METODO UTILITARIO QUE PERMITE CONCATENAR EL MENSAJE FINAL
     *
     * @param messageResponse
     * @return
     */
    public static String joinMessage(MessageResponse messageResponse) {
        return messageResponse.getZero() + messageResponse.getOne() + messageResponse.getTwo() + messageResponse.getThree() + messageResponse.getFour();
    }
}
