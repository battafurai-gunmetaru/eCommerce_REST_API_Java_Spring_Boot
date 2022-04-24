package com.example.restgreeting.data;

import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  @Autowired
  private GreetingRepository greetingRepository;

  private Greeting greeting;

  @Override
  public void run(String... args) throws Exception {
    loadGreetings();
  }

  private void loadGreetings() {
    greeting = greetingRepository.save(new Greeting("hello"));
  }

}
