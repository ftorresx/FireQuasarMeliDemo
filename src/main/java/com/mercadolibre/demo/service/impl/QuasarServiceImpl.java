package com.mercadolibre.demo.service.impl;

import com.mercadolibre.demo.service.QuasarServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * METODO FIRMA DE LOCALIZACION
     * input: distancia al emisor tal cual se recibe en cada satélite
     * output: las coordenadas ‘x’ e ‘y’ del emisor del mensaje
     *
     * @param distances
     * @return COORDENADAS (X , Y) DEL CALCULO DE LA POSICION DE LA NAVE
     */
    public Double[] getLocation(final Double... distances) {
        log.info("INFO distances {}", distances);
        List<Double> satelliteKenobi = Arrays.asList(coordinateXSatelliteKenobi, coordinateYSatelliteKenobi, distances[0]);
        List<Double> satelliteSkywalker = Arrays.asList(coordinateXSatelliteSkywalker, coordinateYSatelliteSkywalker, distances[1]);
        List<Double> satelliteSato = Arrays.asList(coordinateXSatelliteSato, coordinateYSatelliteSato, distances[2]);
        log.info("INFO satelliteKenobi {}", satelliteKenobi);
        /// intercepcion entre Sat1 y Sat2
        List<Double> range1 = this.calculateCoordinatesNave(satelliteKenobi, satelliteSkywalker);
        log.info("INFO intercep1 {}", range1);

        /// intercepcion entre Sat1 y Sat3
        List<Double> range2 = this.calculateCoordinatesNave(satelliteKenobi, satelliteSato);
        log.info("INFO intercep2 {}", range2);

        // evaluacion de intersecciones para encontrar coordenadas
        List<Double> coordsNave = evaluateConditions(range1, range2);
        log.info("INFO COORDENADAS NAVE {}", coordsNave);
        //log.info("coordenadas de la nave: "+ coordsNave.get(0)+", "+coordsNave.get(1));

        return coordsNave.toArray(new Double[coordsNave.size()]);
    }


    /**
     * LOGICA PARA CALCULAR LA POSICION DE LA NAVE SEGUN UN SATELITE
     *
     * @param satA
     * @param satB
     * @return
     */
    private List<Double> calculateCoordinatesNave(List<Double> satA, List<Double> satB) {

        List<Double> coordinates = new ArrayList<>();
        Double x0, y0, r0, x1, y1, r1;
        Double a, dx, dy, d, h, rx, ry, x2, y2;

        x0 = satA.get(0);
        y0 = satA.get(1);
        r0 = satA.get(2);
        x1 = satB.get(0);
        y1 = satB.get(1);
        r1 = satB.get(2);

        dx = x1 - x0;
        dy = y1 - y0;

        d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        if (d > (r0 + r1)) {
            log.info("RESPUESTA INTERSECCION no solution. circles do not intersect {}", coordinates);
            return coordinates;
        }

        if (d < Math.abs(r0 - r1)) {
            log.info("RESPUESTA INTERSECCION no solution. one circle is contained in the other {}", coordinates);
            return coordinates;
        }

        a = ((r0 * r0) - (r1 * r1) + (d * d)) / (2.0 * d);

        x2 = x0 + (dx * a / d);
        y2 = y0 + (dy * a / d);


        h = Math.sqrt((r0 * r0) - (a * a));


        rx = -dy * (h / d);
        ry = dx * (h / d);

        Double x3 = x2 + rx;
        Double x3_prime = x2 - rx;
        Double y3 = y2 + ry;
        Double y3_prime = y2 - ry;

        coordinates.add(x3);
        coordinates.add(y3);
        coordinates.add(x3_prime);
        coordinates.add(y3_prime);

        log.info("RESPUESTA INTERSECCION {}", coordinates);
        return coordinates;
    }

    /**
     * evaluateConditions
     */
    private List<Double> evaluateConditions(List<Double> intercp1, List<Double> intercp2) {

        List<Double> ansNave = new ArrayList<>();
        Double x1_nave, y1_nave;

        if ((intercp1.get(0) < intercp2.get(0) + 5) && (intercp1.get(0) > intercp2.get(0) - 5) &&
                (intercp1.get(1) < intercp2.get(1) + 5) && (intercp1.get(1) > intercp2.get(1) - 5)) {
            log.info("punto 1Circ1 - 1Circ2");
            x1_nave = intercp1.get(0);
            y1_nave = intercp1.get(1);
        } else if ((intercp1.get(0) < intercp2.get(2) + 5) && (intercp1.get(0) > intercp2.get(2) - 5) &&
                (intercp1.get(1) < intercp2.get(3) + 5) && (intercp1.get(1) > intercp2.get(3) - 5)) {
            log.info("punto 1Circ1 - 2Circ2");
            x1_nave = intercp1.get(0);
            y1_nave = intercp1.get(1);
        } else if ((intercp1.get(2) < intercp2.get(0) + 5) && (intercp1.get(2) > intercp2.get(0) - 5) &&
                (intercp1.get(3) < intercp2.get(1) + 5) && (intercp1.get(3) > intercp2.get(1) - 5)) {
            log.info("punto 2Circ1 - 1Circ2");
            x1_nave = intercp1.get(2);
            y1_nave = intercp1.get(3);
        } else if ((intercp1.get(2) < intercp2.get(2) + 5) && (intercp1.get(2) > intercp2.get(2) - 5) &&
                (intercp1.get(3) < intercp2.get(3) + 5) && (intercp1.get(3) > intercp2.get(3) - 5)) {
            log.info("punto 2Circ1 - 2Circ2");
            x1_nave = intercp1.get(2);
            y1_nave = intercp1.get(3);
        } else {
            log.info("punto no encontrado");
            x1_nave = 0.0;
            y1_nave = 0.0;
        }

        ansNave.add(x1_nave);
        ansNave.add(y1_nave);

        return ansNave;
    }


    /**
     * getMessage
     */
    public String getMessage(List<String[]> messages) {
        String msjAnswer = "No hay informacion suficiente para el msj en los 3 satelites";
        int cont = 0;

        List<String> sat1 = new ArrayList<>(), sat2 = new ArrayList<>(), sat3 = new ArrayList<>();

        List<String> listDef = new ArrayList<>();
        if (messages.size() != 3) {
            throw new RuntimeException("Mensaje es erroneo");
        }

        for (String[] listMsg : messages) {

            if (listMsg.length != 5) {
                throw new RuntimeException("Mensaje no tiene la cantidad de mensajes");
            }

            cont++;
            switch (cont) {
                case 1:
                    sat1 = Arrays.asList(listMsg);
                    break;
                case 2:
                    sat2 = Arrays.asList(listMsg);
                    break;
                case 3:
                    sat3 = Arrays.asList(listMsg);
                    break;
                default:
                    break;
            }
        }

        /// comparacion de arrays
        String pos1Sat1 = (sat1.get(0) != null) ? sat1.get(0).trim() : "";
        String pos1Sat2 = (sat2.get(0) != null) ? sat2.get(0).trim() : "";
        String pos1Sat3 = (sat3.get(0) != null) ? sat3.get(0).trim() : "";
        String pos2Sat1 = (sat1.get(1) != null) ? sat1.get(1).trim() : "";
        String pos2Sat2 = (sat2.get(1) != null) ? sat2.get(1).trim() : "";
        String pos2Sat3 = (sat3.get(1) != null) ? sat3.get(1).trim() : "";
        String pos3Sat1 = (sat1.get(2) != null) ? sat1.get(2).trim() : "";
        String pos3Sat2 = (sat2.get(2) != null) ? sat2.get(2).trim() : "";
        String pos3Sat3 = (sat3.get(2) != null) ? sat3.get(2).trim() : "";
        String pos4Sat1 = (sat1.get(3) != null) ? sat1.get(3).trim() : "";
        String pos4Sat2 = (sat2.get(3) != null) ? sat2.get(3).trim() : "";
        String pos4Sat3 = (sat3.get(3) != null) ? sat3.get(3).trim() : "";
        String pos5Sat1 = (sat1.get(4) != null) ? sat1.get(4).trim() : "";
        String pos5Sat2 = (sat2.get(4) != null) ? sat2.get(4).trim() : "";
        String pos5Sat3 = (sat3.get(4) != null) ? sat3.get(4).trim() : "";

        // se evalua la primer posicion
        if (pos1Sat1.length() > 0 || pos1Sat2.length() > 0 || pos1Sat3.length() > 0) {
            if (pos1Sat1.length() > 0 && (pos1Sat1.equalsIgnoreCase(pos1Sat2) || pos1Sat1.equalsIgnoreCase(pos1Sat3)
                    || pos1Sat2.equalsIgnoreCase(pos1Sat3))) {
                listDef.add(pos1Sat1);
            } else if (pos1Sat2.length() > 0 && (pos1Sat2.equalsIgnoreCase(pos1Sat3) || pos1Sat1.equalsIgnoreCase(pos1Sat3))) {
                listDef.add(pos1Sat2);
            } else {
                listDef.add(pos1Sat3);
            }
        } else {
            return msjAnswer;
        }

        // se evalua la segunda posicion
        if (pos2Sat1.length() > 0 || pos2Sat2.length() > 0 || pos2Sat3.length() > 0) {
            if (pos2Sat1.length() > 0 && (pos2Sat1.equalsIgnoreCase(pos2Sat2) || pos2Sat1.equalsIgnoreCase(pos2Sat3)
                    || pos2Sat2.equalsIgnoreCase(pos2Sat3))) {
                listDef.add(pos2Sat1);
            } else if (pos2Sat2.length() > 0 && (pos2Sat2.equalsIgnoreCase(pos2Sat3) || pos2Sat1.equalsIgnoreCase(pos2Sat3))) {
                listDef.add(pos2Sat2);
            } else {
                listDef.add(pos2Sat3);
            }
        } else {
            return msjAnswer;
        }

        // se evalua la tercer posicion
        if (pos3Sat1.length() > 0 || pos3Sat2.length() > 0 || pos3Sat3.length() > 0) {
            if (pos3Sat1.length() > 0 && (pos3Sat1.equalsIgnoreCase(pos3Sat2) || pos3Sat1.equalsIgnoreCase(pos3Sat3)
                    || pos3Sat2.equalsIgnoreCase(pos3Sat3))) {
                listDef.add(pos3Sat1);
            } else if (pos3Sat2.length() > 0 && (pos3Sat2.equalsIgnoreCase(pos3Sat3) || pos3Sat1.equalsIgnoreCase(pos3Sat3))) {
                listDef.add(pos3Sat2);
            } else {
                listDef.add(pos3Sat3);
            }
        } else {
            return msjAnswer;
        }

        // se evalua la cuarta posicion
        if (pos4Sat1.length() > 0 || pos4Sat2.length() > 0 || pos4Sat3.length() > 0) {
            if (pos4Sat1.length() > 0 && (pos4Sat1.equalsIgnoreCase(pos4Sat2) || pos4Sat1.equalsIgnoreCase(pos4Sat3)
                    || pos4Sat2.equalsIgnoreCase(pos4Sat3))) {
                listDef.add(pos4Sat1);
            } else if (pos4Sat2.length() > 0 && (pos4Sat2.equalsIgnoreCase(pos4Sat3) || pos4Sat1.equalsIgnoreCase(pos4Sat3))) {
                listDef.add(pos4Sat2);
            } else {
                listDef.add(pos4Sat3);
            }
        } else {
            return msjAnswer;
        }

        // se evalua la quinta posicion
        if (pos5Sat1.length() > 0 || pos5Sat2.length() > 0 || pos5Sat3.length() > 0) {
            if (pos5Sat1.length() > 0 && (pos5Sat1.equalsIgnoreCase(pos5Sat2) || pos5Sat1.equalsIgnoreCase(pos5Sat3)
                    || pos5Sat2.equalsIgnoreCase(pos5Sat3))) {
                listDef.add(pos5Sat1);
            } else if (pos5Sat2.length() > 0 && (pos5Sat2.equalsIgnoreCase(pos5Sat3) || pos5Sat1.equalsIgnoreCase(pos5Sat3))) {
                listDef.add(pos5Sat2);
            } else {
                listDef.add(pos5Sat3);
            }
        } else {
            return msjAnswer;
        }

        /// se construye la rta del mensaje
        StringBuilder sb = new StringBuilder();
        listDef.forEach((msg) -> {
            sb.append(msg).append(" ");
        });
        msjAnswer = sb.toString();


        return msjAnswer;
    }

}