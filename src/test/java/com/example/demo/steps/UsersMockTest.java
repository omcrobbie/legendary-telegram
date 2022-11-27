package com.example.demo.steps;

import static org.mockito.Mockito.when;

import com.example.demo.DemoApplication;
import com.example.demo.IntegrationTest;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@CucumberContextConfiguration
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
  classes = DemoApplication.class
)
public class UsersMockTest extends IntegrationTest {

  // @Autowired
  // private UserService userService;

  @Autowired
  @MockBean
  private UserRepository userRepository;

  @Given("userRepository has this data")
  public void seed_db(DataTable data) {
    List<List<String>> rows = data.asLists(String.class);
    rows.forEach(row -> {
      when(userRepository.findById(Long.parseLong(row.get(0))))
        .thenReturn(Optional.of(new User(row.get(1))));
    });
  }
}
