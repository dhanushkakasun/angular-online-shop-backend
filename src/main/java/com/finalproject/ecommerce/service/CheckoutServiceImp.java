package com.finalproject.ecommerce.service;

import com.finalproject.ecommerce.dao.CustomerRepository;
import com.finalproject.ecommerce.dto.Purchase;
import com.finalproject.ecommerce.dto.PurchaseResponse;
import com.finalproject.ecommerce.entity.Customer;
import com.finalproject.ecommerce.entity.Order;
import com.finalproject.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;
@Service
public class CheckoutServiceImp implements CheckoutService{
    private CustomerRepository customerRepository;


    public CheckoutServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();


        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);


        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));


        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());


        Customer customer = purchase.getCustomer();
        customer.add(order);


        customerRepository.save(customer) ;


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {


        return UUID.randomUUID().toString();
    }
}
