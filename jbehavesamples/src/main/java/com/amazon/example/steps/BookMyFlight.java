package com.amazon.example.steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.junit.BeforeClass;

public class BookMyFlight extends Steps {
    @BeforeClass()
    public void beforeClass(){
        System.out.println("This is a before class from hooks ");
    }
    @BeforeScenario(uponType = ScenarioType.EXAMPLE)
    public void myFirstJourney(){
        System.out.println("BEFORE SCENARIO from test file");
    }
    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE,uponType = ScenarioType.EXAMPLE)
    public  void faliedcase(){
        System.out.println("i had a bad experience, AFTER SCENARIO FAILED");
    }
    @AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS,uponType = ScenarioType.EXAMPLE)
    public void passedScenario(){
        System.out.println("AFTER SCENARIO PASSED");
    }
    @Given("iam in hyderabad")
    public void myLocation(){
        System.out.println("my current location");
    }
    @When("i choose my source location as $place")
//    @Alias("Hyderabad is selected as my source location")
    @Aliases(values = {"source location is selected as Hyderabad"})
    public void bookFlightTicket(String place){
        System.out.println(place);
    }
    @Then("My destination location shouldnot contain Hyderabad as an option")
    public void verifyDestinationShouldnotContainSource(){
        System.out.println("shouldnot contain hyderabad");
    }
    @Then("select my destination location as $place")
    @Pending
    public void verifySelectingDestination(String place){
        System.out.println("user selected destination place as"+ place);
        Assert.assertTrue(false);
    }
}
