package com.mercadolibre.demo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuasarSplitRequest implements Serializable {

    private String name;

    private String distance;

    public String[] message;

}
