package com.example.restgreeting.tests.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.restgreeting.exceptions.BadDataResponse;
import com.example.restgreeting.models.Greeting;
import com.example.restgreeting.repositories.GreetingRepository;
import com.example.restgreeting.services.GreetingService;
import com.example.restgreeting.services.GreetingServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Example;

class GreetingServiceImplTest {

  @Mock
  private GreetingRepository greetingRepository;
  @Mock
  private GreetingService greetingService; // at mock?
  private AutoCloseable closeable;

  @InjectMocks
  GreetingServiceImpl greetingServiceImpl;

  Greeting greeting;
  List<Greeting> greetingList = new ArrayList<>();

  @BeforeEach
  public void setUp() throws Exception {
    closeable = MockitoAnnotations.openMocks(this);
    greeting = new Greeting("test");
  }

  @AfterEach
  public void tearDown() throws Exception {
    closeable.close();
  }

  @Test
  public void queryGreetingsReturnsCorrectGreetings() {
    when(greetingRepository.findAll()).thenReturn(greetingList);
    List<Greeting> result = greetingServiceImpl.queryGreetings(new Greeting());
    assertEquals(greetingList, result);
  }

  @Test
  public void queryGreetingsByExample() {
    when(greetingRepository.findAll(any(Example.class))).thenReturn(greetingList);
    List<Greeting> result = greetingServiceImpl.queryGreetings(greeting);
    assertEquals(greetingList, result);
  }

  @Test
  public void getGreetingByExistingIdReturnsGreeting() {
    when(greetingRepository.findById(any(Long.class))).thenReturn(Optional.of(greeting));
    Greeting result = greetingServiceImpl.getGreetingById(1L);
    assertEquals(greeting, result);
  }

  @Test
  public void getGreetingByNonExistentIdThrowsNotFound() {
    when(greetingRepository.findById(any(Long.class))).thenThrow(NotFoundException.class);
    assertThrows(NotFoundException.class, () -> greetingServiceImpl.getGreetingById(999L));
  }

  @Test
  public void getGreetingByNegativeIdThrowsBadDataResponse() {
    when(greetingRepository.findById(any(Long.class))).thenThrow(BadDataResponse.class);
    assertThrows(BadDataResponse.class, () -> greetingServiceImpl.getGreetingById(-18L));
  }

  @Test
  public void postGreetingWithValidBodyCreatesSuccessfully() {
    when(greetingRepository.save(any(Greeting.class))).thenReturn(greeting);
    Greeting result = greetingServiceImpl.postGreeting(new Greeting());
    assertEquals(greeting, result);
  }

  @Test
  public void updateGreetingWithValidIdAndBodyReturnsGreetingSuccessfully() {
    when(greetingRepository.findById(any(Long.class))).thenReturn(Optional.of(greeting));
    when(greetingRepository.save(any(Greeting.class))).thenReturn(greeting);
    Greeting result = greetingServiceImpl.updateGreetingById(1L, new Greeting());
    assertEquals(greeting, result);
  }

}