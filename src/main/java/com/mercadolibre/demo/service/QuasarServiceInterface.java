package com.mercadolibre.demo.service;

import java.util.List;

public interface QuasarServiceInterface {

    Double[] getLocation(final Double ... distances);

    String getMessage(List<String[]> messages);

}
