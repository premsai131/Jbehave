package com.amazon.example.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class Login extends Steps {
    @Given( "User is on loginpage")
        public void verifyLoginpage(){
System.out.println("User should be on login page");
        }
    @When("User enters username as $uname and password as $pword")
    public void enterCreds(String uname, String pword ){
        System.out.println(uname + pword);
    }
    @Then("user clicks on signbutton")
    public void clickOnSignIn(){
        System.out.println("User clicked on signin button");
    }
    @Then ("user should see homepage")
    public void seesHomePage(){
        System.out.println("User shoud be on homepage");
    }
}
