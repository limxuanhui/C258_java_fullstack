package com.josephlxh.PizzaOrderApp.controller;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dao.PizzaDao;
import com.josephlxh.PizzaOrderApp.dto.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private PizzaDao dao;

    @GetMapping("/{pizzaId}")
    Pizza getPizzaById(@PathVariable("pizzaId") Integer pizzaId) {
        return null;
    }

    @GetMapping("/")
    List<Pizza> getAllPizzas() {
        return null;
    }

    @PostMapping("/")
    Pizza createPizza(@RequestBody Pizza pizza) {
        // pizzaRepository.save(pizza);
        return null;
    }

    @PutMapping("/")
    Pizza editPizza(@RequestBody Pizza pizza) {
        return null;
    }

    @DeleteMapping("/{pizzaId}")
    Pizza deletePizza() {
        return null;
    }
}
