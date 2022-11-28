package com.example.demo.common;

import io.restassured.response.Response;

public class IntegrationTest {

  private Response response;

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public int getLastResponseStatusCode() {
    return response.statusCode();
  }

  public String getLastResponseString() {
    return response.getBody().asString();
  }
}
