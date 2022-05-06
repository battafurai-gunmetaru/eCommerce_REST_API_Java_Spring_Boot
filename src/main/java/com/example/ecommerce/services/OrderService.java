package com.example.ecommerce.services;

import com.example.ecommerce.models.Order;
import java.util.List;

public interface OrderService {

  List<Order> queryOrders(Order order);

  Order getOrderById(Long id);

  Order addOrder(Order order);

  Order updateOrderById(Long id, Order order);

  void deleteOrderById(Long id);

}
