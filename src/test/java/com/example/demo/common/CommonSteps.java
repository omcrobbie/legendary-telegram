package com.example.demo.common;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends IntegrationTest {

  @Autowired
  private MockMvc mvc;

  @When("I call GET {string}")
  public void getPath(String url) throws Exception {
    setResponse(mvc.perform(get(url)));
  }

  @When("I call POST {string} with payload from {string}")
  public void postPath(String url, String payloadName) throws Exception {
    String filePath = getClass().getResource(String.format("/data/%s.json", payloadName)).getPath();
    File file = new File(filePath);
    ResultActions response = mvc
        .perform(
            post(url).contentType(MediaType.APPLICATION_JSON).content(Files.readAllBytes(file.toPath())));
    setResponse(response);
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(getLastResponseStatusCode(), code);
  }

  @Then("I assert property {string} is {string}")
  public void validateBody(String jsonPath, String expected) throws Exception {
    if (!expected.isEmpty()) {
      getResponse().andExpect(MockMvcResultMatchers.jsonPath(jsonPath).value(expected));
    }
  }

  @Then("I assert entity with {string} {string} exists in response")
  public void validateBodyEntity(String prop, String expected) throws Exception {
    if (!expected.isEmpty()) {
      String query = String.format("$.[?(@.%s=='%s')].%s", prop, expected, prop);
      getResponse().andExpect(MockMvcResultMatchers.jsonPath(query).value(expected));
    }
  }
  // https://advancedtestautomation.blogspot.com/2020/03/tricks-to-query-or-filter-json-using.html

  @Then("I assert {int} entities are returned")
  public void i_assert_entities_are_returned(Integer num) throws Exception {
    getResponse().andExpect(MockMvcResultMatchers.jsonPath("$..name", hasSize(num)));
  }
}
