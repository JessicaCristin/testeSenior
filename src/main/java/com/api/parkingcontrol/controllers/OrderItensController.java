package com.api.parkingcontrol.controllers;


import com.api.parkingcontrol.dtos.ItemDto;
import com.api.parkingcontrol.dtos.OrderItensDto;
import com.api.parkingcontrol.model.ItemModel;
import com.api.parkingcontrol.service.OrderItensService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@Controller
@RequestMapping("/orderItens")
public class OrderItensController {

    final OrderItensService orderItensService;

    public OrderItensController(OrderItensService orderItensService) {
        this.orderItensService = orderItensService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody OrderItensDto orderItensDto) {

        var orderItens = orderItensService.create(orderItensDto);

        if (orderItens == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(orderItens);
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        var orderItens = orderItensService.list();

        if (orderItens == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No results");
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderItens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id) {
        var orderItens = orderItensService.delete(id);

        if (!orderItens) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find the order!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable(value = "id") UUID id) {
        var orderItens = orderItensService.read(id);

        if (orderItens == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No results");
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderItens);
    }



}
