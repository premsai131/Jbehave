package com.amazon.example.hooks;

import com.amazon.example.browsersetup.BaseTest;
import com.amazon.example.pages.HomePage;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ApplicationHooks extends BaseTest {
    BaseTest baseTest;
  public HomePage homePage;
    WebDriver driver;

    public ApplicationHooks() throws IOException {
        super();
    }
    @BeforeStory
    public void setup() throws IOException, InterruptedException {
        baseTest = new BaseTest();
       driver = baseTest.intialization();
        homePage = new HomePage(driver);
    }
    @BeforeScenario
    public void clickOnSignInPage() throws IOException, InterruptedException {
        baseTest.visitWebsite();
        homePage.clickOnYourAccountsSignIn();
    }


}
