package com.bookmark.bookmark;

import com.bookmark.bookmark.order.Order;
import com.bookmark.bookmark.order.OrderRepository;
import com.bookmark.bookmark.order.dtos.CreateOrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void createOrderWithoutCustomer_ReturnsCreatedOrder() throws Exception {
        Order order = new Order();
        String requestBody = objectMapper.writeValueAsString(order);

        mvc.perform(
                post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isCreated());
    }

    @Test
    void createOrderWithInvalidCustomerId_ReturnsError() throws Exception {
        var order = new CreateOrderDto(1L);
        String requestBody = objectMapper.writeValueAsString(order);

        mvc.perform(
                post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isUnprocessableEntity());
    }

    @Test
    void updateOrderStatus_ReturnsUpdatedOrder() throws Exception {
        Order order = orderRepository.save(new Order());

        mvc.perform(
                        post(String.format("/orders/%d/quote", order.getId()))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isUnprocessableEntity());
    }
}
