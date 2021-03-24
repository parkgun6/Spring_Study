package org.geon.controller;

import java.util.concurrent.ExecutionException;

import org.geon.domain.Order;
import org.geon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class OrderController {

    @Autowired
    OrderService storeService;

    @GetMapping("/getOrder")
    public ResponseEntity<Order> get(@RequestParam String store) throws InterruptedException, ExecutionException{
        log.info("--------------controller----------------------");
        log.info(store);
        Order order = storeService.getOrder(store);
    	return new ResponseEntity<Order>(order,HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public String create(@RequestBody Order order) throws InterruptedException, ExecutionException {
    	 log.info("--------------controller----------------------");
    	return storeService.insertOrder(order);
    }

    @PutMapping("/updateOrder")
    public String update(@RequestBody Order order  ) throws InterruptedException, ExecutionException {
    	 log.info("--------------controller----------------------");
    	log.info(order);
    	return storeService.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder")
    public String delete(@RequestParam String store) throws InterruptedException, ExecutionException{
    	 log.info("--------------controller----------------------");
    	return storeService.deleteOrder(store);
    }
}