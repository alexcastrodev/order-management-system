package com.bookmark.bookmark.customer;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
}
