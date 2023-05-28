package com.onlydan.od.services;

import com.onlydan.od.dto.OrdersDTO;
import com.onlydan.od.entities.Orders;
import com.onlydan.od.entities.PaymentDetails;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.OrdersMapper;
import com.onlydan.od.repositories.OrdersRepository;
import com.onlydan.od.repositories.PaymentDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final PaymentDetailsRepository paymentDetailsRepository;
    private final OrdersMapper ordersMapper;

    //POST REQUESTS
    public OrdersDTO createOrder(OrdersDTO ordersDTO) {
        PaymentDetails paymentDetail = paymentDetailsRepository.findById(ordersDTO.getPaymentDetailId())
                .orElseThrow(AllExceptions::PaymentDetailNotFound);

        Orders order = Orders.builder()
                .paymentDetailsId(paymentDetail)
                .build();

        Orders savedOrder = ordersRepository.save(order);

        return ordersMapper.INSTANCE.toDTO(savedOrder);
    }

    //PUT REQUESTS
    public OrdersDTO updateOrderByOrderId(Long orderId, OrdersDTO ordersDTO) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(AllExceptions::OrderNotFound);

        PaymentDetails paymentDetails = paymentDetailsRepository.findById(ordersDTO.getPaymentDetailId())
                .orElseThrow(AllExceptions::PaymentDetailNotFound);

        order.setPaymentDetailsId(paymentDetails);

        Orders updatedOrder = ordersRepository.save(order);
        return ordersMapper.INSTANCE.toDTO(updatedOrder);
    }

    // GET REQUESTS
    public OrdersDTO getOrderByOrderId(Long orderId) {
        Orders order = ordersRepository.findById(orderId)
                .orElseThrow(AllExceptions::OrderNotFound);
        return ordersMapper.INSTANCE.toDTO(order);
    }

    // DELETE REQUESTS
    public void deleteOrderByOrderId(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
