package com.mercadolibre.demo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuasarDTO implements Serializable {

    private List<SatelliteDTO> satellites;

    public List<SatelliteDTO> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatelliteDTO> satellites) {
        this.satellites = satellites;
    }
}
