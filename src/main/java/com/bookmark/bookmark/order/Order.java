package com.bookmark.bookmark.order;

import com.bookmark.bookmark.customer.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Customer customer;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status = OrderStatus.DRAFTING;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }
}
