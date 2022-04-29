package com.example.restgreeting.services;

import static com.example.restgreeting.constants.StringConstants.NOT_FOUND;

import com.example.restgreeting.exceptions.BadDataResponse;
import com.example.restgreeting.exceptions.ResourceNotFound;
import com.example.restgreeting.exceptions.ServiceUnavailable;
import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.repositories.GreetingRepository;
import java.util.Comparator;
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
        List<Greeting> greetings = greetingRepository.findAll();
        greetings.sort(Comparator.comparing(Greeting::getId));
        return greetings;
      } else {
        Example<Greeting> greetingExample = Example.of(greeting);
        return greetingRepository.findAll(greetingExample);
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new ServiceUnavailable(e);
    }
  }

  @Override
  public Greeting getGreetingById(Long id) {
    if (id < 1) {
      throw new BadDataResponse("id must be positive and cannot be zero");
    }
    Greeting greetingLookUpResult;
    try {
      greetingLookUpResult = greetingRepository.findById(id).orElse(null);
      if (greetingLookUpResult != null) {
        return greetingLookUpResult;
      }
    } catch (Exception e) {
      throw new ServiceUnavailable(e.getMessage());
    }
    throw new ResourceNotFound(NOT_FOUND + " greeting with id " + id);
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
    if (id < 1) {
      throw new BadDataResponse("id must be positive and cannot be zero");
    }
    Greeting updatedGreeting = null;
    if (!greetingRepository.existsById(id)) {
      throw new ResourceNotFound(NOT_FOUND + "greeting with id " + id);
    }
    try {
      greeting.setId(id);
      updatedGreeting = greetingRepository.save(greeting);
    } catch (Exception e) {
      throw new ServiceUnavailable(e);
    }
    return updatedGreeting;
  }

  @Override
  public void deleteGreetingById(Long id) {
    if (id < 1) {
      throw new BadDataResponse("id must be positive and cannot be zero");
    }
    getGreetingById(id);
    try {
      greetingRepository.deleteById(id);
    } catch (Exception e) {
      throw new ServiceUnavailable("Something went wrong");
    }
  }
}
