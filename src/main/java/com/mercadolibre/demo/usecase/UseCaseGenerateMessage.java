package com.mercadolibre.demo.usecase;

import com.mercadolibre.demo.enums.ErrorEnum;
import com.mercadolibre.demo.misc.UtilSatellites;
import com.mercadolibre.demo.model.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UseCaseGenerateMessage {

    /**
     * METODO QUE PERMITE CONSOLIDAR EL MENSAJE ENVIADO POR LA NAVE A LOS DIFERENTES SATELITES
     *
     * @param messages
     * @return
     */
    public String generateMessage(List<String[]> messages) {
        MessageResponse messageResponse = new MessageResponse();
        String messageProcess = null;
        try {
            messageResponse = UtilSatellites.mixMessage(messages.get(0), messageResponse);
            messageResponse = UtilSatellites.mixMessage(messages.get(1), messageResponse);
            messageResponse = UtilSatellites.mixMessage(messages.get(2), messageResponse);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(ErrorEnum.ERROR_MESSAGE.getId());
        }
        return UtilSatellites.joinMessage(messageResponse);
    }
}
