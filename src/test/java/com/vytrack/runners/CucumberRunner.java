package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features",
        glue = "com.vytrack.step_definitions",
        dryRun = false,
        //tags = "@negative_test or @driver"
        //tags = " ~@negative_test"  // ~ with this senario does not run
        tags = "",
        plugin = {"html:target/default-cucumber-reports"}
)
public class CucumberRunner {



}
