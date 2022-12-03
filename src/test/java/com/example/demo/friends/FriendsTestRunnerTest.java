package com.example.demo.friends;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/FriendsMock.feature", extraGlue = "com.example.demo.common")
public class FriendsTestRunnerTest {

}
