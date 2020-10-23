package com.mercadolibre.demo.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PositionResponse implements Serializable {

    private CoordinatesResponse position;
    private String message;

}
