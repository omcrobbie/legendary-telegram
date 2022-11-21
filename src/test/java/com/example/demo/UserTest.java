package com.example.demo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = DemoApplication.class,
  webEnvironment = WebEnvironment.DEFINED_PORT
)
public class UserTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Before
  public void seed_db() {
    userService.addOne(new User("Jimmy"));
  }

  @Test
  public void test() {
    Mockito
      .when(userRepository.findById(anyLong()))
      .thenReturn(Optional.of(new User("shithead")));

    get("/users/6")
      .then()
      .assertThat()
      .statusCode(200)
      .and()
      .body("name", is("shithead"));
  }

  @Test
  public void mock_test() {
    Mockito
      .when(userRepository.findById(anyLong()))
      .thenReturn(Optional.empty());

    get("/users/6").then().assertThat().statusCode(404);
  }
}
