package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.OrderDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/admin/order-details")
public interface OrderDetailsAdminAPI {
    // POST REQUESTS
    @PostMapping
    ResponseEntity<OrderDetailsDTO> createOrderDetails(@Valid @RequestBody OrderDetailsDTO orderDetailsDTO);

    // PUT REQUESTS
    @PutMapping("/{details-id}")
    ResponseEntity<OrderDetailsDTO> updateOrderDetailsByDetailsId(@PathVariable("details-id") Long detailsId,
                                                                  @Valid @RequestBody OrderDetailsDTO orderDetailsDTO);

    // GET REQUESTS
    @GetMapping
    ResponseEntity<OrderDetailsDTO> getOrderDetailsByDetailsId(@RequestParam("details-id") @Valid Long detailsId);

    // DELETE REQUESTS
    @DeleteMapping("/{details-id}")
    ResponseEntity<Void> deleteOrderDetailsByDetailsId(@PathVariable("details-id") @Valid Long detailsId);
}
