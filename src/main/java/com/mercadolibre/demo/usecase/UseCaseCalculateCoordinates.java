package com.mercadolibre.demo.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UseCaseCalculateCoordinates {

    /**
     * METODO QUE CALCULA LA TRIANGULACION DE LA NAVE CON DOS (COORDENADAS)
     *
     * @param pointOne
     * @param pointTwo
     * @return
     */
    public List<Double> triangulatePosition(List<Double> pointOne, List<Double> pointTwo) {

        List<Double> positionNaveList = new ArrayList<>();
        Double x1satellite, y1Satellite;
        if ((pointOne.get(0) < pointTwo.get(0) + 5) && (pointOne.get(0) > pointTwo.get(0) - 5) &&
                (pointOne.get(1) < pointTwo.get(1) + 5) && (pointOne.get(1) > pointTwo.get(1) - 5)) {
            x1satellite = pointOne.get(0);
            y1Satellite = pointOne.get(1);
        } else if ((pointOne.get(0) < pointTwo.get(2) + 5) && (pointOne.get(0) > pointTwo.get(2) - 5) &&
                (pointOne.get(1) < pointTwo.get(3) + 5) && (pointOne.get(1) > pointTwo.get(3) - 5)) {
            x1satellite = pointOne.get(0);
            y1Satellite = pointOne.get(1);
        } else if ((pointOne.get(2) < pointTwo.get(0) + 5) && (pointOne.get(2) > pointTwo.get(0) - 5) &&
                (pointOne.get(3) < pointTwo.get(1) + 5) && (pointOne.get(3) > pointTwo.get(1) - 5)) {
            x1satellite = pointOne.get(2);
            y1Satellite = pointOne.get(3);
        } else if ((pointOne.get(2) < pointTwo.get(2) + 5) && (pointOne.get(2) > pointTwo.get(2) - 5) &&
                (pointOne.get(3) < pointTwo.get(3) + 5) && (pointOne.get(3) > pointTwo.get(3) - 5)) {
            x1satellite = pointOne.get(2);
            y1Satellite = pointOne.get(3);
        } else {
            x1satellite = 0.0;
            y1Satellite = 0.0;
        }
        positionNaveList.add(x1satellite);
        positionNaveList.add(y1Satellite);

        return positionNaveList;
    }

    /**
     * METODO MATEMATICO QUE CONTIENE LA LOGICA PARA ENCONTRAR EL PUNTO ENTRE LA INTERSECCION DE DOS CIRCULOS
     * REFERENCIA: https://stackoverrun.com/es/q/5384586
     *
     * @param satA
     * @param satB
     * @return
     */
    public List<Double> calculateCoordinatesNave(List<Double> satA, List<Double> satB) {

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

        if (d > (r0 + r1) | d < Math.abs(r0 - r1)) {
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

        return coordinates;
    }
}
