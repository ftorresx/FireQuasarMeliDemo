package com.mercadolibre.demo.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesDTO implements Serializable {

    private Double x;
    private Double y;

}