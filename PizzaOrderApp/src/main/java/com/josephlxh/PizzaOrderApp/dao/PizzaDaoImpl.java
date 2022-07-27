package com.josephlxh.PizzaOrderApp.dao;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Pizza;
import com.josephlxh.PizzaOrderApp.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PizzaDaoImpl implements PizzaDao {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Optional<Pizza> get(Integer pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @Override
    public Pizza create(Pizza pizza) {
        return null;
    }

    @Override
    public Pizza edit(Pizza pizza) {
        return null;
    }

    @Override
    public Pizza delete(Pizza pizza) {
        return null;
    }
}
