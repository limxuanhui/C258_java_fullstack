package com.josephlxh.PizzaOrderApp.repository;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
