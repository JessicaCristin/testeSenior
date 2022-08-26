package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.OrderDto;
import com.api.parkingcontrol.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody OrderDto orderDto) {

        var order = orderService.create(orderDto);

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") UUID id) {
        var order = orderService.delete(id);

        if (!order) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find the order!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        var order = orderService.list();

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No results");
        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable(value = "id") UUID id) {
        var order = orderService.read(id);

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No results");
        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, OrderDto orderDto){
        var order = orderService.update(id, orderDto);

        if (order == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not edit order");
        }

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

}

