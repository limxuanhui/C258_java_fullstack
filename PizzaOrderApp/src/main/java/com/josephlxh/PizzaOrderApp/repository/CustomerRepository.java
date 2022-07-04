package com.josephlxh.PizzaOrderApp;
/* Created by limxuanhui on 30/6/22 */

import com.josephlxh.PizzaOrderApp.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
