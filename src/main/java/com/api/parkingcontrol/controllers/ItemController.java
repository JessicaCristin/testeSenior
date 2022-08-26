package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ItemDto;
import com.api.parkingcontrol.model.ItemModel;
import com.api.parkingcontrol.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ItemController {

    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid ItemDto itemDto) {
        var itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDto, itemModel);
        var item = itemService.create(itemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") UUID id) {
        var item = itemService.delete(id);

        if (!item) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find the item!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        var item = itemService.list();
        if(item == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find the item!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> read(@PathVariable(value = "id") UUID id) {
        var item = itemService.read(id);

        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem resultados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, ItemDto itemDto) {
        var item = itemService.update(id, itemDto);

        if (item == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not edit order");
        }

        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
}


