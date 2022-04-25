package com.example.restgreeting.services;

import com.example.restgreeting.models.Greeting;
import java.util.List;

public interface GreetingService {

  List<Greeting> queryGreetings(Greeting greeting);

  Greeting getGreetingById(Long id);

  Greeting postGreeting(Greeting greeting);

  Greeting updateGreetingById(Long id, Greeting greeting);

  void deleteGreetingById(Long id);
}
