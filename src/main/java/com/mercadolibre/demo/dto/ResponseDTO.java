package com.mercadolibre.demo.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {

    private CoordinatesDTO position;
    private String message;

}
