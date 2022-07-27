package com.josephlxh.PizzaOrderApp.controller;
/* Created by limxuanhui on 30/6/22 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String home() {
        return "Hi welcome to Joseph Pizza House!";
    }
}
