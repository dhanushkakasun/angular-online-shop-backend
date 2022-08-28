package com.finalproject.ecommerce.dao;

import com.finalproject.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
