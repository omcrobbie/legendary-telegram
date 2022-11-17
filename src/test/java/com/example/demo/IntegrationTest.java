package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

public abstract class IntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate rest;

  private ObjectMapper mapper = new ObjectMapper();

  private ResponseEntity<?> responseEntity;

  private String getUrl(String url) {
    return String.format("http://localhost:%s%s", port, url);
  }

  public void get(String url) {
    responseEntity = rest.getForEntity(getUrl(url), Object.class);
  }

  public int getLastStatus() {
    return responseEntity.getStatusCode().value();
  }

  public <T> List<T> getDataLastResponse(TypeReference<List<T>> ref)
    throws JsonProcessingException {
    return mapper.convertValue(responseEntity.getBody(), ref);
  }

  public <T> T getDataLastResponse(Class<T> ref) {
    return mapper.convertValue(responseEntity.getBody(), ref);
  }
}
