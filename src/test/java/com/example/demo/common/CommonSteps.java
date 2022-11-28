package com.example.demo.common;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.springframework.boot.test.web.server.LocalServerPort;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CommonSteps extends IntegrationTest {

  @LocalServerPort
  private int port;

  private String getLocalPath(String url) {
    return String.format("http://localhost:%d%s", port, url);
  }

  @When("I call GET {string}")
  public void getPath(String url) {
    setResponse(get(getLocalPath(url)));
  }

  @When("I call POST {string} with payload from {string}")
  public void postPath(String url, String payloadName) {
    String filePath = getClass().getResource(String.format("/data/%s.json", payloadName)).getPath();
    File file = new File(filePath);
    Response response = given().contentType(ContentType.JSON).body(file).when().post(getLocalPath(url));
    setResponse(response);
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

  @Then("I assert entity with {string} {string} exists in response")
  public void validateBodyEntity(String jsonPath, String expected) {
    if (!expected.isEmpty()) {
      List<String> body = getResponse().jsonPath().getList(jsonPath);
      assertTrue(body.contains(expected));
    }
  }
}
