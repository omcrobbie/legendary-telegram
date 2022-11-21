package com.example.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.user.User;
import com.example.demo.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersFeatureTest {

  @Autowired
  private UserService userService;

  private Response response;

  @Before
  public void seed_db() {
    userService.addOne(new User("Jimmy"));
    // Mockito.lenient().when(userRepository.findById(anyLong())).thenReturn(null);
  }

  @When("I call GET {string}")
  public void getAll(String url) {
    response = get(url);
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(response.statusCode(), code);
  }

  @And("I assert the name is {string}")
  public void validateBody(String expected)
    throws JsonMappingException, JsonProcessingException {
    User user = response.getBody().as(User.class);
    assertEquals(user.getName(), expected);
  }
}
