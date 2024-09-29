package com.bookmark.bookmark.order;

import com.bookmark.bookmark.customer.Customer;
import com.bookmark.bookmark.customer.CustomerRepository;
import com.bookmark.bookmark.expections.RecordNotFoundException;
import com.bookmark.bookmark.order.dtos.CreateOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order saveOrder(CreateOrderDto orderDto) {
        Order order = new Order();

        if (orderDto.customerId() != null) {
            Customer customer = this.customerRepository.findById(orderDto.customerId())
                    .orElseThrow(() -> new OrderValidationException("Customer not found"));
            order.setCustomer(customer);
        }

        return orderRepository.save(order);
    }

    // TODO: Change to Spring State machine
    public Order changeStatusToQuote(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderValidationException("Order not found"));

        if (order.getCustomer() == null) {
            throw new OrderValidationException("Customer not found");
        }

        order.setStatus(OrderStatus.QUOTE);
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Order not found"));
    }
}
