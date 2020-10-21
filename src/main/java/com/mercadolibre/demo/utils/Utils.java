package com.mercadolibre.demo.utils;

import com.mercadolibre.demo.dto.QuasarDTO;
import com.mercadolibre.demo.dto.SatelliteDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public final class Utils {

    public static Double[] getDistances(final QuasarDTO quasarDTO) {
        log.info(" quasarDTO UTIL : {}", quasarDTO);
        List<Double> distances = new ArrayList<>();
        for (SatelliteDTO satelliteDTO : quasarDTO.getSatellites()) {
            if (satelliteDTO.getName().equalsIgnoreCase("Kenobi")) {
                distances.add(0, satelliteDTO.getDistance());
            }
            if (satelliteDTO.getName().equalsIgnoreCase("Skywalker")) {
                distances.add(1, satelliteDTO.getDistance());
            }
            if (satelliteDTO.getName().equalsIgnoreCase("Sato")) {
                distances.add(2, satelliteDTO.getDistance());
            }
        }
        log.info(" DISTANCES UTIL : {}", distances);
        return distances.toArray(new Double[distances.size()]);
    }


    public static List<String[]> getMessages(final QuasarDTO quasarDTO) {
        List<String[]> messages = new ArrayList<>();

        for (SatelliteDTO satelliteDTO : quasarDTO.getSatellites()) {
            messages.add(satelliteDTO.getMessage());
        }
        return messages;
    }
}
