package com.bookmark.bookmark.order;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderStatusEvents> {
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusEvents> transitions) throws Exception {
        transitions.
                withExternal()
                .source(OrderStatus.DRAFTING)
                .target(OrderStatus.QUOTE)
                .event(OrderStatusEvents.NEGOTIATING);
    }

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusEvents> states) throws Exception {
        states.withStates()
                .initial(OrderStatus.DRAFTING)
                .end(OrderStatus.COMPLETED)
                .end(OrderStatus.CANCELLED)
                .states(EnumSet.allOf(OrderStatus.class));
    }
}
