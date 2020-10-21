package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.dto.AnswerDTO;
import com.mercadolibre.demo.dto.PositionDTO;
import com.mercadolibre.demo.dto.QuasarDTO;
import com.mercadolibre.demo.service.QuasarServiceInterface;
import com.mercadolibre.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
@Slf4j
public class QuasarController {

    @Autowired
    private QuasarServiceInterface quasarService;


    @PostMapping(path = "/topsecret", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> coordNave(@RequestBody final QuasarDTO quasarDTO) {
        log.info("INGRESA A MENSAJE SATELITE {}", quasarDTO);
        Double[] distance = quasarService.getLocation(Utils.getDistances(quasarDTO));
        log.info("distance ::: {}", distance);
        String message = quasarService.getMessage(Utils.getMessages(quasarDTO));

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setX(distance[0]);
        positionDTO.setY(distance[1]);
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setPosition(positionDTO);
        answerDTO.setMessage(message);

        return ResponseEntity.ok(answerDTO);
    }


}
