package com.mercadolibre.demo.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuasarSatellitesRequest implements Serializable {

    private List<Satellite> satellites;

}
