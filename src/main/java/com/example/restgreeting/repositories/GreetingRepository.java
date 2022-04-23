package com.example.restgreeting.repositories;


import com.example.restgreeting.models.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
