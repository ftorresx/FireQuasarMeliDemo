package com.mercadolibre.demo.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageResponse implements Serializable {

    private String zero;
    private String one;
    private String two;
    private String three;
    private String four;

}
