package com.amazon.example.stepDefinitions;

import com.amazon.example.browsersetup.BaseTest;

import com.amazon.example.pages.HomePage;
import com.amazon.example.pages.LoginPage;
import com.amazon.example.utils.SessionStorage;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.io.IOException;

public class LoginWithOutCreds extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private  BaseTest baseTest;
    private SessionStorage sessionStorage;
    public LoginWithOutCreds() throws IOException {
        super();
    }

    @BeforeStory()
    public void setup() throws InterruptedException, IOException {
        baseTest = new BaseTest();
        driver = baseTest.intialization();
        baseTest.visitWebsite();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        sessionStorage = new SessionStorage(driver);
    }
    @Given ("user is on Amazon home page")
    public void VerifyAmazonLogo(){
          Assert.assertTrue(homePage.seesAmazonLogoInHomePage());
    }
    @When("user tries to restore session details")
    public void verifyResstoringTheSessionDetails() throws InterruptedException {
             sessionStorage.readCookies();
    }

    @Then ("user should be logged in and should see user's name in header section")
    public void VerifySuccessFullLoginAfterSessionRestoring(){

        Assert.assertEquals("username not matching","premsai" , homePage.getSigninUsername());
    }
}
