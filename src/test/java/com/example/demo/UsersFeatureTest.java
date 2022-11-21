package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.user.User;
import com.example.demo.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersFeatureTest extends IntegrationTest {

  @Autowired
  private UserService userService;

  @Before
  public void seed_db() {
    userService.addOne(new User("Jimmy"));
    // Mockito.lenient().when(userRepository.findById(anyLong())).thenReturn(null);
  }

  @When("I call GET {string}")
  public void getAll(String url) {
    get(url);
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(getLastStatus(), code);
  }

  @And("I assert the name is {string}")
  public void validateBody(String expected)
    throws JsonMappingException, JsonProcessingException {
    User user = getDataLastResponse(User.class);
    assertEquals(user.getName(), expected);
  }
}