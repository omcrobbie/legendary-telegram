package com.example.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import com.example.demo.utils.DataNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = DemoApplication.class,
  webEnvironment = WebEnvironment.DEFINED_PORT
)
public class UserTest {

  @Autowired
  ApplicationContext context;

  @MockBean
  private UserService userService;

  @Autowired
  UserRepository userRepository;

  @Before
  public void seed_db() {
    userRepository.save(new User("Jimmy"));
  }

  @Test
  public void test() {
    get("/users/1")
      .then()
      .assertThat()
      .statusCode(200)
      .and()
      .body("name", is("Jimmy"));
  }

  @Test
  public void mock_test() throws DataNotFoundException {
    Mockito
      .when(userService.getOne(anyString()))
      .thenThrow(DataNotFoundException.class);

    get("/users/6").then().assertThat().statusCode(404);
  }
}
