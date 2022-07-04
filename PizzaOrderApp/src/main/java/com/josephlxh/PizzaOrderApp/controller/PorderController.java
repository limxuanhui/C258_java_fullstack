package com.josephlxh.PizzaOrderApp.controller;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.PizzaPorderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PizzaPorderController {

    private PizzaPorderRepository pizzaPorderRepository;

    public PizzaPorderController(PizzaPorderRepository pizzaPorderRepository) {
        this.pizzaPorderRepository = pizzaPorderRepository;
    }



}
