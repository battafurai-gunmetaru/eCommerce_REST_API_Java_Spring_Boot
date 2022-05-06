package com.example.ecommerce.models;

import static com.example.ecommerce.constants.StringConstants.REQUIRED_FIELD;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.OptBoolean;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Valid
  private Long customerId;

  @NotBlank(message = "date" + REQUIRED_FIELD)
  @JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  @Valid
  private Set<Item> items = new HashSet<>();

  @NotNull(message = "order total" + REQUIRED_FIELD)
  @NumberFormat(style = Style.CURRENCY)
  private BigDecimal orderTotal;

  public Order() {
  }

  public Order(Long customerId, Date date, Set<Item> items, BigDecimal orderTotal) {
    this.customerId = customerId;
    this.date = date;
    this.items = items;
    this.orderTotal = orderTotal;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }

  public BigDecimal getOrderTotal() {
    return orderTotal;
  }

  public void setOrderTotal(BigDecimal orderTotal) {
    this.orderTotal = orderTotal;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", customerId=" + customerId +
        ", date=" + date +
        ", items=" + items +
        ", orderTotal=" + orderTotal +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(id, order.id) && Objects.equals(customerId,
        order.customerId) && Objects.equals(date, order.date) && Objects.equals(
        items, order.items) && Objects.equals(orderTotal, order.orderTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerId, date, items, orderTotal);
  }

  @JsonIgnore
  public boolean isEmpty() {
    return
        Objects.isNull(id) &&
            Objects.isNull(customerId) &&
            Objects.isNull(date) &&
            Objects.isNull(items) &&
            Objects.isNull(orderTotal);
  }
}
