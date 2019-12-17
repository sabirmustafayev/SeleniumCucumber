package com.vytrack.step_definitions;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setup(){
        System.out.println("Test setup!");
    }

    @After
    public void teardown(Scenario scenario){
        //if test failed -- do this
        if (scenario.isFailed()){
            System.out.println("Test failed");
        }
        System.out.println("Cleanup!");
        System.out.println("Test completed");
    }
}
