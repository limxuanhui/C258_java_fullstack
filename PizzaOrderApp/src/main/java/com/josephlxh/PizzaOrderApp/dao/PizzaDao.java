package com.josephlxh.PizzaOrderApp.dao;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Pizza;

import java.util.Optional;

public interface PizzaDao {
    Optional<Pizza> get(Integer pizzaId);
    Pizza create(Pizza pizza);
    Pizza edit(Pizza pizza);
    Pizza delete(Pizza pizza);
}
