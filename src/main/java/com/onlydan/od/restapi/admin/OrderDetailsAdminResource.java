package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.OrderDetailsDTO;
import com.onlydan.od.services.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderDetailsAdminResource implements OrderDetailsAdminAPI {
    private final OrderDetailsService orderDetailsService;

    // POST
    @Override
    public ResponseEntity<OrderDetailsDTO> createOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        log.info("Order details #{} added", orderDetailsDTO.getOrderDetailsId());
        OrderDetailsDTO orderDetailsDto = orderDetailsService.createOrderDetails(orderDetailsDTO);
        return ResponseEntity.created(URI.create("/api/order-details" + orderDetailsDto.getOrderDetailsId())).body(orderDetailsDto);
    }

    // PUT
    @Override
    public ResponseEntity<OrderDetailsDTO> updateOrderDetailsByDetailsId(Long detailsId, OrderDetailsDTO orderDetailsDTO) {
        log.info("Order details id #{} updated", detailsId);
        OrderDetailsDTO orderDetailsDto = orderDetailsService.updateOrderDetailsByDetailsId(detailsId, orderDetailsDTO);
        return ResponseEntity.ok(orderDetailsDto);
    }

    // GET
    @Override
    public ResponseEntity<OrderDetailsDTO> getOrderDetailsByDetailsId(Long detailsId) {
        log.info("Order details id #{} fetched", detailsId);
        return ResponseEntity.ok(orderDetailsService.getOrderDetailsByDetailsId(detailsId));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteOrderDetailsByDetailsId(Long detailsId) {
        log.info("Order details id #{} deleted", detailsId);
        orderDetailsService.deleteOrderDetailsByDetailsId(detailsId);
        return ResponseEntity.noContent().build();
    }
}
