package com.example.ecommerce.data;

import static com.example.ecommerce.constants.StringConstants.ADMIN;
import static com.example.ecommerce.constants.StringConstants.EMPLOYEE;

import com.example.ecommerce.models.Address;
import com.example.ecommerce.models.Customer;
import com.example.ecommerce.models.Greeting;
import com.example.ecommerce.models.Item;
import com.example.ecommerce.models.Order;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.CustomerRepository;
import com.example.ecommerce.repositories.GreetingRepository;
import com.example.ecommerce.repositories.ItemRepository;
import com.example.ecommerce.repositories.OrderRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.UserRepository;
import com.google.common.collect.Sets;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
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
  private ItemRepository itemRepository;
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
  private Product productTwo;
  private Product productThree;
  private Product productFour; // randomizer for products?

  private User user;
  private User userTwo;
  private User userThree;
  private User userFour;

  private Item item = new Item();
  private Item itemTwo = new Item();
  private Item itemThree = new Item();
  private Item itemFour = new Item();

  private Address addressOne = new Address("64 Zoo Lane", "Paris", "TX", "23592");
  private Address addressTwo = new Address("1125 Main Street", "Elwood city", "MA", "02532");
  private Address addressThree = new Address("124 Conch Street", "Bikini Bottom", "CA", "94103");
  private Address addressFour = new Address("30 Pixie way", "Dimmsdale", "CA", "90210");

  @Override
  public void run(String... args) throws Exception {
    loadGreetings();
    loadCustomers();
    loadItems();
    loadOrders();
    loadProducts();
    loadUsers();
  }

  private Date createDate(String dateValue) {
    String datePattern = "yyyy-MM-dd";
    SimpleDateFormat dateFor = new SimpleDateFormat(datePattern);
    Date createdDate = null;
    try {
      createdDate = dateFor.parse(dateValue);
    } catch (Exception e) {
      throw new RuntimeException("Date could not be parsed");
    }
    return createdDate;
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
        new Customer("Timmy Turner", "timothy_turner@outlook.com", addressFour));

  }

  private void loadItems() {
    item = itemRepository.save(new Item(1L, 23, order));
    itemTwo = itemRepository.save(new Item(2L, 13, orderTwo));
    itemThree = itemRepository.save(new Item(3L, 5, orderThree));
    itemFour = itemRepository.save(new Item(4L, 8, orderFour));
  }

  private void loadOrders() {
    Set<Item> itemList = Sets.newHashSet(item);
    Set<Item> itemListTwo = Sets.newHashSet(itemTwo);
    Set<Item> itemListThree = Sets.newHashSet(itemThree);
    Set<Item> itemListFour = Sets.newHashSet(itemFour);

    order = orderRepository.save( // change up these orders a bit
        new Order(1L, createDate("04-22-2022"), itemList, new BigDecimal("23.99")));
    orderTwo = orderRepository.save(
        new Order(2L, createDate("06-12-2021"), itemListTwo, new BigDecimal("23.99")));
    orderThree = orderRepository.save(
        new Order(3L, createDate("12-09-2020"), itemListThree, new BigDecimal("23.99")));
    orderFour = orderRepository.save(
        new Order(4L, createDate("05-01-2022"), itemListFour, new BigDecimal("23.99")));
  }

  private void loadProducts() { // maybe this should go before items???
    product = productRepository.save(new Product("MD5-354", "Women's Fashion", "Wide Brim Sunhat",
        "UPF 50+ Sun Hat to protect against UV rays", "Keeper's", new BigDecimal("15.95")));
    productTwo = productRepository.save(new Product("VG8-771", "Video Game Consoles And Accessories", "Deep, Dark Sea",
        "Explore 8 levels of fun in this thrilling deep sea adventure!", "Tinker Entertainment", new BigDecimal("49.99")));
    productThree = productRepository.save(new Product("CS4-956", "Kitchen Cookware", "Hydro-dynamic Spatula",
        "Comes with port and starboard attachments, and turbo-drive setting", "Barg N' Mart", new BigDecimal("2.79")));
    productFour = productRepository.save(new Product("MD5-354", "Women's Fashion", "Wide Brim Sunhat",
        "UPF 50+ Sun Hat to protect against UV rays", "Keeper's", new BigDecimal("15.95")));
  }

  private void loadUsers() {
    user = userRepository.save(new User("Claire Redfield", "employee", new String[] {EMPLOYEE}, "", "password12345"));
    userTwo = userRepository.save(new User("Colby Jack", "employee", new String[] {EMPLOYEE}, "", "pastrami25"));
    userThree = userRepository.save(new User("Duragin Fohrs", "Systems Administrator", new String[] {ADMIN}, "", "theseventhseal1"));
    userFour = userRepository.save(new User("Michael Scott", "Boss", new String[] {ADMIN}, "", "supersecretpassword1!"));
  }


}
