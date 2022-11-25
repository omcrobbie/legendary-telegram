package com.example.demo;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

@CucumberContextConfiguration
@SpringBootTest(
  webEnvironment = WebEnvironment.DEFINED_PORT,
  classes = DemoApplication.class
)
public class UsersFeatureTest {

  // @Autowired
  // private UserService userService;

  @Autowired
  @MockBean
  private UserRepository userRepository;

  private Response response;

  @Before
  public void seed_db() {
    when(userRepository.findById(1L))
      .thenReturn(Optional.of(new User("Jimmy")));
    when(userRepository.findById(2L)).thenReturn(Optional.of(new User("Jill")));
  }

  @When("I call GET {int}")
  public void getAll(int userId) {
    response = get("/users/" + userId);
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(response.statusCode(), code);
  }

  @And("I assert property {string} is {string}")
  public void validateBody(String jsonPath, String expected) {
    if (!expected.isEmpty()) {
      assertEquals(response.jsonPath().get(jsonPath), expected);
    }
  }
}
