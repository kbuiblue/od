package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.DailyOrdersDTO;
import com.onlydan.od.dto.DailyRevenueDTO;
import com.onlydan.od.dto.OrderDetailsDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/daily-revenue")
    ResponseEntity<List<DailyRevenueDTO>> getDailyRevenueFromDateRange(@RequestParam("startDate")
                                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                       @RequestParam("endDate")
                                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate);

    @GetMapping("/daily-orders")
    ResponseEntity<List<DailyOrdersDTO>> getDailyOrdersFromDateRange(@RequestParam("startDate")
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                     @RequestParam("endDate")
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate);

    // DELETE REQUESTS
    @DeleteMapping("/{details-id}")
    ResponseEntity<Void> deleteOrderDetailsByDetailsId(@PathVariable("details-id") @Valid Long detailsId);
}
