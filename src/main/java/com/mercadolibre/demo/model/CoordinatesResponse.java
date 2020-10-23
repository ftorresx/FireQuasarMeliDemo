package com.mercadolibre.demo.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesResponse implements Serializable {

    private Double x;
    private Double y;

}
