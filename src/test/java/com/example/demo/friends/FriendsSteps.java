package com.example.demo.friends;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.DemoApplication;
import com.example.demo.common.IntegrationTest;
import com.example.demo.friend.Friend;
import com.example.demo.friend.FriendRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@CucumberContextConfiguration
public class FriendsSteps extends IntegrationTest {

    @MockBean
    @Autowired
    private FriendRepository friendRepository;

    @Given("user has these friends")
    public void setMock(DataTable table) {

        table
                .cells()
                .stream()
                .skip(1)
                .forEach(row -> {
                    User user = new User();
                    List<Friend> friends = new ArrayList<>();
                    row.stream().skip(1).forEach(col -> {
                        friends.add(new Friend(col, "friend", user));
                    });
                    when(friendRepository.findAll()).thenReturn(friends);
                });
    }

}
