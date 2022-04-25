package com.example.restgreeting.services;

import static com.example.restgreeting.constants.StringConstants.NOT_FOUND;

import com.example.restgreeting.exceptions.ResourceNotFound;
import com.example.restgreeting.exceptions.ServiceUnavailable;
import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.repositories.GreetingRepository;
import java.util.List;
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
      logger.error(e.getMessage());
      throw new ServiceUnavailable(e);
    }
  }

  public Greeting getGreetingById(Long id) {
    try {
      Greeting greetingLookupResult = greetingRepository.findById(id).orElse(null);
      if (greetingLookupResult != null) {
        return greetingLookupResult;
      } throw new ResourceNotFound(NOT_FOUND + " greeting with id " + id);
    } catch (Exception e) { //
      logger.error(e.getMessage());
      throw new ServiceUnavailable(e);
    }
  }

  @Override
  public Greeting postGreeting(Greeting greeting) {
    try {
      return greetingRepository.save(greeting);
    } catch (Exception e) {
      throw new ServiceUnavailable(e);
    }
  }

  @Override
  public Greeting updateGreetingById(Long id, Greeting greeting) {

    boolean greetingExists = greetingRepository.existsById(id);
    if (!greetingExists) {
      throw new ResourceNotFound(NOT_FOUND + "greeting with id " + id);
    }
    try {
      return greetingRepository.save(greeting);
    } catch (Exception e) {
      throw new ServiceUnavailable(e);
    }
  }

  @Override
  public void deleteGreetingById(Long id) {
    try {
      getGreetingById(id);
      greetingRepository.deleteById(id);
    } catch (Exception e) {
      throw new ServiceUnavailable(e);
    }
  }
}
