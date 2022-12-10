package com.example.demo.IT.common;

import org.springframework.test.web.servlet.ResultActions;

public class IntegrationTest {

  private ResultActions response;

  public ResultActions getResponse() {
    return response;
  }

  public void setResponse(ResultActions response) {
    this.response = response;
  }

  public int getLastResponseStatusCode() {
    return response.andReturn().getResponse().getStatus();
  }
}
