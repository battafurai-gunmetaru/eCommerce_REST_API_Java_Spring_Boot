package com.example.restgreeting.controllers;

import static com.example.restgreeting.constants.StringConstants.QUERY_REQUEST;

import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.services.GreetingService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

  private final Logger logger = LoggerFactory.getLogger(GreetingController.class);

  @Autowired
  private GreetingService greetingService;

  @GetMapping
  public ResponseEntity<List<Greeting>> queryGreetings(Greeting greeting) {
    logger.info(new Date() + QUERY_REQUEST + greeting.toString());

    return new ResponseEntity<>(greetingService.queryGreetings(greeting), HttpStatus.OK);
  }
}
