package com.cristian.tiusers;


import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;


@Suite
@IncludeEngines("cucumber")
@RunWith(Cucumber.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.cristian.tiusers.steps", "com.cristian.tiusers"}
)
public class CucumberTest {
}