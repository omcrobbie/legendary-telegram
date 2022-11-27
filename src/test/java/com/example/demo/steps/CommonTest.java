package com.example.demo.steps;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import com.example.demo.IntegrationTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonTest extends IntegrationTest {

  @When("I call GET {string}")
  public void getAll(String url) {
    setResponse(get(url));
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(getLastResponseStatusCode(), code);
  }

  @Then("I assert property {string} is {string}")
  public void validateBody(String jsonPath, String expected) {
    if (!expected.isEmpty()) {
      assertEquals(getResponse().jsonPath().get(jsonPath), expected);
    }
  }
}
