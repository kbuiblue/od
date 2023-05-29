package com.onlydan.od.services;

import com.onlydan.od.dto.*;
import com.onlydan.od.entities.OrderDetails;
import com.onlydan.od.entities.Orders;
import com.onlydan.od.entities.ProductInfo;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.OrderDetailsMapper;
import com.onlydan.od.repositories.OrderDetailsRepository;
import com.onlydan.od.repositories.OrdersRepository;
import com.onlydan.od.repositories.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderDetailsMapper orderDetailsMapper;
    private final OrdersRepository ordersRepository;
    private final ProductInfoRepository productInfoRepository;

    //POST REQUESTS
    public OrderDetailsDTO createOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        ProductInfo productInfo = productInfoRepository.findById(orderDetailsDTO.getProductId())
                .orElseThrow(AllExceptions::ProductInfoNotFound);
        Orders order = ordersRepository.findById(orderDetailsDTO.getOrderDetailsId())
                .orElseThrow(AllExceptions::OrderNotFound);

        OrderDetails orderDetails = OrderDetails.builder()
                .isOnSale(orderDetailsDTO.getIsOnSale())
                .orderDate(orderDetailsDTO.getOrderDate())
                .productPrice(orderDetailsDTO.getProductPrice())
                .productQuantity(orderDetailsDTO.getProductQuantity())
                .salePercentage(orderDetailsDTO.getSalePercentage())
                .productInfo(productInfo)
                .order(order)
                .build();

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetailsMapper.INSTANCE.toDTO(savedOrderDetails);
    }

    //PUT REQUESTS
    public OrderDetailsDTO updateOrderDetailsByDetailsId(Long detailsId, OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepository.findById(detailsId)
                .orElseThrow(AllExceptions::OrderDetailsNotFound);
        ProductInfo productInfo = productInfoRepository.findById(orderDetailsDTO.getProductId())
                .orElseThrow(AllExceptions::ProductInfoNotFound);
        Orders order = ordersRepository.findById(orderDetailsDTO.getOrderDetailsId())
                .orElseThrow(AllExceptions::OrderNotFound);

        orderDetails.setIsOnSale(orderDetailsDTO.getIsOnSale());
        orderDetails.setOrderDate(orderDetailsDTO.getOrderDate());
        orderDetails.setProductPrice(orderDetailsDTO.getProductPrice());
        orderDetails.setProductQuantity(orderDetailsDTO.getProductQuantity());
        orderDetails.setSalePercentage(orderDetailsDTO.getSalePercentage());
        orderDetails.setProductInfo(productInfo);
        orderDetails.setOrder(order);

        OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);

        return orderDetailsMapper.INSTANCE.toDTO(updatedOrderDetails);
    }
    //GET REQUESTS
    public OrderDetailsDTO getOrderDetailsByDetailsId(Long detailsId) {
        OrderDetails orderDetails = orderDetailsRepository.findById(detailsId)
                .orElseThrow(AllExceptions::OrderDetailsNotFound);
        return orderDetailsMapper.INSTANCE.toDTO(orderDetails);
    }

    public List<DailyRevenueDTO> getDailyRevenueFromDateRange(LocalDate startDate, LocalDate endDate) {
        return orderDetailsRepository.getDailyRevenueFromDateRange(startDate, endDate);
    }

    public List<DailyOrdersDTO> getDailyOrdersFromDateRange(LocalDate startDate, LocalDate endDate) {
        return orderDetailsRepository.getDailyOrdersFromDateRange(startDate, endDate);
    }

    public List<BestSellingProductsDTO> getBestSellingProductsFromDateRange(Integer topN, LocalDate startDate, LocalDate endDate) {
        return orderDetailsRepository.getBestSellingProductsFromDateRange(topN, startDate, endDate);
    }

    public List<WorstSellingProductsDTO> getWorstSellingProductsFromDateRange(Integer topN, LocalDate startDate, LocalDate endDate) {
        return orderDetailsRepository.getWorstSellingProductsFromDateRange(topN, startDate, endDate);
    }

    //DELETE REQUESTS
    public void deleteOrderDetailsByDetailsId(Long detailsId) {
        orderDetailsRepository.deleteById(detailsId);
    }
}
