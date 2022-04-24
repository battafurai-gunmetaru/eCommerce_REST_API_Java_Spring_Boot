package com.example.restgreeting.models;

import static com.example.restgreeting.constants.StringConstants.REQUIRED_FIELD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "greetings")
public class Greeting {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "greeting" + REQUIRED_FIELD)
  private String greeting;

  public Greeting() {
  }

  public Greeting(String greeting) {
    this.greeting = greeting;
  }

  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Greeting greeting1 = (Greeting) o;
    return id == greeting1.id && Objects.equals(greeting, greeting1.greeting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, greeting);
  }

  @Override
  public String toString() {
    return "Greeting{" + "Id=" + id + ", greeting='" + greeting + '\'' + '}';
  }

  @JsonIgnore
  public boolean isEmpty() {
    return Objects.isNull(id) &&
        Objects.isNull(greeting);
  }

}
