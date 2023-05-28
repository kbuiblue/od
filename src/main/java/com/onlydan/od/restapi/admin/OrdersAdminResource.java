package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.OrdersDTO;
import com.onlydan.od.services.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrdersAdminResource implements OrdersAdminAPI {

    private final OrdersService ordersService;

    // POST
    @Override
    public ResponseEntity<OrdersDTO> createOrder(OrdersDTO ordersDTO) {
        log.info("Order id #{} added", ordersDTO.getOrderId());
        OrdersDTO ordersDto = ordersService.createOrder(ordersDTO);
        return ResponseEntity.created(URI.create("/api/orders" + ordersDto.getOrderId())).body(ordersDto);
    }

    // PUT
    @Override
    public ResponseEntity<OrdersDTO> updateOrderByOrderId(Long orderId, OrdersDTO ordersDTO) {
        log.info("Order id #{} updated", orderId);
        OrdersDTO orderDto = ordersService.updateOrderByOrderId(orderId, ordersDTO);
        return ResponseEntity.ok(orderDto);
    }

    // GET
    @Override
    public ResponseEntity<OrdersDTO> getOrderByOrderId(Long orderId) {
        log.info("Order id #{} fetched", orderId);
        return ResponseEntity.ok(ordersService.getOrderByOrderId(orderId));
    }

    @Override
    public ResponseEntity<Void> deleteOrderByOrderId(Long orderId) {
        log.info("Order id #{} deleted", orderId);
        ordersService.deleteOrderByOrderId(orderId);
        return ResponseEntity.noContent().build();
    }
}
