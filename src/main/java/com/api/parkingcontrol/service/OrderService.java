package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dtos.OrderDto;
import com.api.parkingcontrol.model.OrderModel;
import com.api.parkingcontrol.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderService {

        final OrderRepository orderRepository;

        public OrderService( OrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

        @Transactional
        public OrderModel create(OrderDto orderDto) {

            var order = new OrderModel();
            order.setNumber(orderDto.getNumber());
            order.setPercentualDiscount(orderDto.getPercentualDiscount());
            order.setTotalValue(orderDto.getTotalValue());

            var resultado = orderRepository.save(order);

            return resultado;
        }

        public boolean delete(UUID id) {
            var orderId = orderRepository.findById(id);

            if (!orderId.isPresent()) {
                return false;
            }

            orderRepository.deleteById(id);
            return true;
        }

        public OrderModel read(UUID id) {
            var orderId = orderRepository.findById(id);

            if (!orderId.isPresent()) {
                return null;
            }

            return orderId.get();
        }

        public ArrayList<OrderDto> list() {
            var listOrder = orderRepository.findAll();

            if (listOrder.isEmpty()) {
                return null;
            }

            var listOrderDto = new ArrayList<OrderDto>();

            for (OrderModel order : listOrder) {

                var orderDto = new OrderDto();
                orderDto.setId(order.getId());
                orderDto.setOrderItens(order.getOrderItens());
                orderDto.setOrderItens(order.getOrderItens());
                orderDto.setNumber(order.getNumber());
                orderDto.setPercentualDiscount(order.getPercentualDiscount());
                orderDto.setTotalValue(order.getTotalValue());

                listOrderDto.add(orderDto);

            }
            return listOrderDto;
        }

        @Transactional
        public OrderModel update(UUID id, OrderDto orderDto){
            var order = orderRepository.findById(id).get();

            if(order == null){
                return null;
            }

            order.setOrderItens(orderDto.getOrderItens());
            order.setNumber(orderDto.getNumber());
            order.setPercentualDiscount(orderDto.getPercentualDiscount());
            order.setTotalValue(orderDto.getTotalValue());

            return orderRepository.save(order);
        }

    }
