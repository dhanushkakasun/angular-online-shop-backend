package com.finalproject.ecommerce.dto;

import com.finalproject.ecommerce.entity.Address;
import com.finalproject.ecommerce.entity.Customer;
import com.finalproject.ecommerce.entity.Order;
import com.finalproject.ecommerce.entity.OrderItem;

import java.util.Set;

import lombok.Data;
@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
