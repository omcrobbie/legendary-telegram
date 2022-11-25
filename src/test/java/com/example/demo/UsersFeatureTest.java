package com.example.demo;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import org.mockito.Mockito;
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
    Mockito
      .when(userRepository.findById(anyLong()))
      .thenReturn(Optional.of(new User("Jimmy")));
  }

  @When("I call GET {string}")
  public void getAll(String url)
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    // Method m = RestAssured.class.getMethod(method.toLowerCase(), URL.class);
    response = get(url);
  }

  @Then("I get status code {int}")
  public void validateCode(int code) {
    assertEquals(response.statusCode(), code);
  }

  @And("I assert {string} is {string}")
  public void validateBody(String jsonPath, String expected) {
    assertEquals(response.jsonPath().get(jsonPath), expected);
  }
}
