package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.OrdersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/admin/orders")
public interface OrdersAdminAPI {
    //POST REQUESTS
    @PostMapping
    ResponseEntity<OrdersDTO> createOrder(@Valid @RequestBody OrdersDTO ordersDTO);

    @PutMapping("/{order-id}")
    ResponseEntity<OrdersDTO> updateOrderByOrderId(@PathVariable("order-id") Long orderId, @Valid @RequestBody OrdersDTO ordersDTO);

    //GET REQUESTS
    @GetMapping
    ResponseEntity<OrdersDTO> getOrderByOrderId(@RequestParam("order-id") Long orderId);

    //DELETE REQUESTS
    @DeleteMapping
    ResponseEntity<Void> deleteOrderByOrderId(@RequestParam("order-id") Long orderId);
}
