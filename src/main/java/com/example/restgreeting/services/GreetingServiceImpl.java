package com.example.restgreeting.services;

import com.example.restgreeting.exceptions.ServiceUnavailable;
import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.repositories.GreetingRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  private final Logger logger = LoggerFactory.getLogger(GreetingService.class);

  @Autowired
  private GreetingRepository greetingRepository;

  @Override
  public List<Greeting> queryGreetings(Greeting greeting) {
    try {
      if (greeting.isEmpty()) {
        return greetingRepository.findAll();
      } else {
        Example<Greeting> greetingExample = Example.of(greeting);
        return greetingRepository.findAll(greetingExample);
      }
    } catch (Exception e) {
      logger.info(new Date() + e.getMessage());
      throw e; // might have to change this later
    }
  }

  public Greeting getGreetingById(Long id) {
    try {
      Greeting greetingLookupResult = greetingRepository.findById(id).orElse(null);
      if(greetingLookupResult != null){
        return greetingLookupResult;
      }

    } catch (Exception e) {
      throw new ServiceUnavailable(e); // might have to change this later
    }
      throw new EntityNotFoundException();
  }
}
