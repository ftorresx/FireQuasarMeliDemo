package com.mercadolibre.demo.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SateliteDTO implements Serializable {

    private String name;
    private Double distance;
    private String[] message;

}
