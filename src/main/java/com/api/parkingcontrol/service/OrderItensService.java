package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dtos.ItemDto;
import com.api.parkingcontrol.dtos.OrderItensDto;
import com.api.parkingcontrol.model.ItemModel;
import com.api.parkingcontrol.model.OrderItensModel;
import com.api.parkingcontrol.repositories.OrderItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderItensService {
    @Autowired
    final OrderItensRepository orderItensRepository;

    public OrderItensService(OrderItensRepository orderItensRepository) {
        this.orderItensRepository = orderItensRepository;
    }

    @Transactional
    public OrderItensModel create(OrderItensDto orderItensDto) {

        var orderItens = new OrderItensModel();

        if ((orderItens.getItem() == null) || (orderItens.getOrder() == null)) {
            return null;
        }

        orderItens.setId(orderItensDto.getId());
        orderItens.setOrder(orderItensDto.getOrder());
        orderItens.setItem(orderItensDto.getItem());
        orderItens.setQuantity(orderItensDto.getQuantity());
        orderItens.setTotalValue(orderItensDto.getTotalValue());

        return orderItens;
    }

    public ArrayList<OrderItensDto> list() {
        var listOrderItem = orderItensRepository.findAll();

        if (listOrderItem.isEmpty()) {
            return null;
        }

        var listOrderItensDto = new ArrayList<OrderItensDto>();

        for (OrderItensModel orderItemModel : listOrderItem) {

            var orderItensDto = new OrderItensDto();

            orderItensDto.setId(orderItemModel.getId());
            orderItensDto.setOrder(orderItemModel.getOrder());
            orderItensDto.setQuantity(orderItemModel.getQuantity());
            orderItensDto.setTotalValue(orderItemModel.getTotalValue());


            listOrderItensDto.add(orderItensDto);

        }
        return listOrderItensDto;
    }

    public boolean delete(UUID id) {
        var orderItemId = orderItensRepository.findById(id);

        if (!orderItemId.isPresent()) {
            return false;
        }

        orderItensRepository.deleteById(id);
        return true;
    }

    public OrderItensModel read(UUID id) {
        var orderItemId = orderItensRepository.findById(id);

        if (!orderItemId.isPresent()) {
            return null;
        }

        return orderItemId.get();
    }

    @Transactional
    public OrderItensModel update(UUID id, OrderItensDto orderItemDto) {
        var orderItensModel = orderItensRepository.findById(id).get();

        if (orderItensModel == null) {
            return null;
        }

        orderItensModel.setOrder(orderItemDto.getOrder());
        orderItensModel.setItem(orderItemDto.getItem());
        orderItensModel.setQuantity(orderItemDto.getQuantity());
        orderItensModel.setTotalValue(orderItemDto.getTotalValue());


        return orderItensRepository.save(orderItensModel);
    }
}
