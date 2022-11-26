package com.shopper.ecommerce.dto;

import com.shopper.ecommerce.entity.Address;
import com.shopper.ecommerce.entity.Customer;
import com.shopper.ecommerce.entity.Order;
import com.shopper.ecommerce.entity.OrderItem;
import lombok.Data;
import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
