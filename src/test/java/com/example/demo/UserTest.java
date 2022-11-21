package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = DemoApplication.class,
  webEnvironment = WebEnvironment.RANDOM_PORT
)
public class UserTest extends IntegrationTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Before
  public void seed_db() {
    userService.addOne(new User("Jimmy"));
    Mockito
      .when(userRepository.findById(anyLong()))
      .thenReturn(Optional.of(new User("shithead")));
    // Mockito.lenient().when(userRepository.findById(anyLong())).thenReturn(null);
  }

  @Test
  public void test() throws JsonMappingException, JsonProcessingException {
    get("/users/6");
    assertEquals(getLastStatus(), 200);
    User user = getDataLastResponse(User.class);
    assertEquals(user.getName(), "shithead");
  }

  @Test
  public void mock_test() {
    get("/users/6");
    assertEquals(getLastStatus(), 200);
    assertEquals(getDataLastResponse(User.class).getName(), "shithead");
  }
}
