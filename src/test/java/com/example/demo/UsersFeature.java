package com.example.demo;

import static org.junit.Assert.assertEquals;

import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import com.example.demo.utils.DataNotFoundException;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersFeature {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService service;

  @When("I ensure his name is {string}")
  public void getAll(String name) throws DataNotFoundException {
    assertEquals(userRepository.count(), 5);
    assertEquals(service.getOne("1").getName(), name);
  }
}
