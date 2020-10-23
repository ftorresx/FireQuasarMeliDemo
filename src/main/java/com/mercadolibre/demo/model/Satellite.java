package com.mercadolibre.demo.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Satellite implements Serializable {

    private String name;
    private Double distance;
    private String[] message;

}
