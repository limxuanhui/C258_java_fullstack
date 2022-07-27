package com.josephlxh.PizzaOrderApp.repository;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Porder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorderRepository extends JpaRepository<Porder, Integer> {

}
