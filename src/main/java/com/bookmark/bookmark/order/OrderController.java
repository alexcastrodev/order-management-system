package com.bookmark.bookmark.order;

import com.bookmark.bookmark.customer.CustomerService;
import com.bookmark.bookmark.order.dtos.CreateOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody CreateOrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @PostMapping(value = "/{id}/quote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Order changeStatusToQuote(@PathVariable Long id) {
        return orderService.changeStatusToQuote(id);
    }
}
