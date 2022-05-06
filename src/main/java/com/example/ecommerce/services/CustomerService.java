package com.example.ecommerce.services;

import com.example.ecommerce.models.Customer;
import java.util.List;

public interface CustomerService {

  List<Customer> queryCustomers(Customer customer);

  Customer getCustomerById(Long id);

  Customer addCustomer(Customer customer);

  Customer updateCustomerById(Long id, Customer customer);

  void deleteCustomerById(Long id);

}
