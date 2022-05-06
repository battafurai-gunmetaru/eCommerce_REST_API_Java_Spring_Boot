package com.example.ecommerce.data;

import com.example.ecommerce.models.Address;
import com.example.ecommerce.models.Customer;
import com.example.ecommerce.models.Greeting;
import com.example.ecommerce.models.Item;
import com.example.ecommerce.models.Order;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.CustomerRepository;
import com.example.ecommerce.repositories.GreetingRepository;
import com.example.ecommerce.repositories.OrderRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * This class loads data into the database upon launching the application
 */
@Component
public class DataLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

  @Autowired
  private GreetingRepository greetingRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private UserRepository userRepository;

  private Greeting greeting;
  private Greeting greetingTwo;

  private Customer customer;
  private Customer customerTwo;
  private Customer customerThree;
  private Customer customerFour;

  private Order order;
  private Order orderTwo;
  private Order orderThree;
  private Order orderFour;

  private Product product;
  private Product ProductTwo;
  private Product ProductThree;
  private Product productFour; // randomizer for products?

  private User user;
  private User userTwo;
  private User userThree;
  private User userFour;

  private Item itemOne = new Item();
  private Item itemTwo = new Item();

  private Address addressOne = new Address("64 Zoo Lane", "Paris", "TX", "23592");
  private Address addressTwo = new Address("1125 Main Street", "Elwood city", "MA", "02532");
  private Address addressThree = new Address ("124 Conch Street", "Bikini Bottom", "CA", "94103");
  private Address addressFour = new Address ("", "", "");

  @Override
  public void run(String... args) throws Exception {
    loadGreetings();
    loadCustomers();
    loadOrders();
    loadProducts();
    loadUsers();
  }

  private void loadGreetings() {
    greeting = greetingRepository.save(new Greeting("hello"));
    greetingTwo = greetingRepository.save(new Greeting("hi"));
  }

  private void loadCustomers() {
    customer = customerRepository.save(
        new Customer("Lucy Vrombaut", "lvrombaut@hotmail.com", addressOne));
    customerTwo = customerRepository.save(
        new Customer("Arthur Reed", "a_reed@student.uml.edu", addressTwo));
    customerThree = customerRepository.save(
        new Customer("Spongebob Squarepants", "imready@krustykrab.com", addressThree));
    customerFour = customerRepository.save(
        new Customer(""));

  }

  private void loadOrders() {
    order = orderRepository.save(new Order());
  }

  private void loadProducts() {
    product = productRepository.save(new Product());

  }

  private void loadUsers() {
    user = userRepository.save(new User());
  }


}
