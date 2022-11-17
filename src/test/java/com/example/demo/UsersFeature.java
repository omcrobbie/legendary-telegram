package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class UsersFeature extends IntegrationTest {

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
    List<User> users = getDataLastResponse(new TypeReference<List<User>>() {});
    assertEquals(users.get(0).getName(), expected);
  }
}
