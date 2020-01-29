package com.packen;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/packen/login-test/IniciodeSession.feature")
public class TestRunning {

    public static void main(String[] args) {

    }
}
