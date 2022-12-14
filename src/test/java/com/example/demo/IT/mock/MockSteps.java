package com.example.demo.IT.mock;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.IT.TestContext;
import com.example.demo.IT.common.IntegrationTest;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = TestContext.class)
@CucumberContextConfiguration
public class MockSteps extends IntegrationTest {

  @Autowired
  @MockBean
  private UserRepository userRepository;

  @Given("userRepository has this data")
  public void setMocks(DataTable data) {
    List<Map<String, String>> rows = data.asMaps(String.class, String.class);
    rows.forEach(row -> {
      when(userRepository.findById(Long.parseLong(row.get("userid"))))
          .thenReturn(Optional.of(new User(row.get("name"))));
    });
  }
}
