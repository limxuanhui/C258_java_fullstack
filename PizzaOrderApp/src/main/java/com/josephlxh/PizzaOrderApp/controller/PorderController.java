package com.josephlxh.PizzaOrderApp.controller;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.repository.PorderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PorderController {

    private PorderRepository porderRepository;

    public PorderController(PorderRepository porderRepository) {
        this.porderRepository = porderRepository;
    }



}
