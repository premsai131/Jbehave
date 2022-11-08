package com.amazon.example.steps;

import com.amazon.example.browsersetup.BaseTest;
import com.amazon.example.pages.HomePage;
import com.amazon.example.pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPageTest extends BaseTest {

    WebDriver driver;
    BaseTest baseTest;
    LoginPage loginPage;
    HomePage homePage;
    SoftAssertions softAssertions;
    public LoginPageTest() throws IOException {
        super();
    }
    @BeforeStory(order = 0)
    public void setupAndVisitApplication() throws IOException, InterruptedException {
        baseTest = new BaseTest();
       driver = baseTest.intialization();
        baseTest.visitWebsite();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);


    }
    @BeforeStory()
//    public void verifyClickingOnAccountsButton(){
//        homePage.clickOnYourAccountsSignIn();
//        softAssertions = new SoftAssertions();
//        softAssertions.assertThat(loginPage.seesSignInText());
//    }
    @BeforeScenario(uponType = ScenarioType.EXAMPLE)
    public void verifyClickingOnAccountsButton() throws InterruptedException {
        homePage.clickOnYourAccountsSignIn();
    }
    @AfterScenario(uponType = ScenarioType.EXAMPLE)
    public void navigateBacktoHomePage() throws InterruptedException {
        baseTest.visitWebsite();
    }
    @Given("user is on amazon login page")
    public void verifyVisibilityOfLoginpageLogo(){
        boolean flag =loginPage.seesAmazonLogo();
        Assert.assertTrue(flag);
        softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.seesSignInText());
    }
    @When("user enters the username as $uname")
    public void verifyEnteringUserName(String uname){
        loginPage.enterUsername(uname);
    }
    @Then("user should see invalid username error after clicking on continue button")
    public void verifyErrorMessage(){
        loginPage.clickOnContinueButton();
String errorMessage = loginPage.seesErrorMessageForInvalidEmail();
Assert.assertEquals(errorMessage,"We cannot find an account with that email address");
    }

    @When ("user enters username as $uname")
    public void verifyEnteringValidUsername(String uname){
        loginPage.enterUsername(uname);
    }
    @Then ("user clicks on continue button")
    public void clickOnContinueButton(){
        loginPage.clickOnContinueButton();
    }
    @Then ("user enters password as $password")
    public void enterPassword(String password){
        loginPage.enterpassword(password);
        loginPage.clickOnSignInButton();
    }
    @Then ("user should see error message after clicking on signin button")
    public void VerifyErrorMessageAfterprovidingInvalidPassword(){
        String errormessage = loginPage.seesErrorMessageForInvalidPassword();
        Assert.assertEquals("error message not matching, assertion failed",errormessage,"Your password is incorrect");
    }
}
