package com.amazon.example.stepDefinitions;


import com.amazon.example.browsersetup.BaseTest;
import com.amazon.example.pages.HomePage;
import com.amazon.example.pages.LoginPage;
import com.amazon.example.utils.Emailer;
import com.amazon.example.utils.SessionStorage;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

public class LoginPageTest extends BaseTest {
    private WebDriver driver;
    private BaseTest baseTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private Emailer email;
    private SessionStorage sessionStorage;
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
        sessionStorage = new SessionStorage(driver);
    }

    //    @BeforeStory()
////    public void verifyClickingOnAccountsButton(){
////        homePage.clickOnYourAccountsSignIn();
////        softAssertions = new SoftAssertions();
////        softAssertions.assertThat(loginPage.seesSignInText());
////    }
    @BeforeScenario(uponType = ScenarioType.ANY)
    public void verifyClickingOnAccountsButton() throws InterruptedException {
        homePage.clickOnYourAccountsSignIn();
    }

    @AfterScenario(uponType = ScenarioType.EXAMPLE)
    public void navigateBacktoHomePage() throws InterruptedException {
        baseTest.visitWebsite();
    }

    @Given("user is on amazon login page")
    public void verifyVisibilityOfLoginpageLogo() {
        boolean flag = loginPage.seesAmazonLogo();
        Assert.assertTrue(flag);
        softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.seesSignInText());
    }
    @When("user enters the username as $uname")
    public void verifyEnteringUserName(String uname) {
        loginPage.enterUsername(uname);
    }

    @Then("user should see invalid username error after clicking on continue button")
    public void verifyErrorMessage() {
        loginPage.clickOnContinueButton();
        String errorMessage = loginPage.seesErrorMessageForInvalidEmail();
        Assert.assertEquals(errorMessage, "We cannot find an account with that email address");
    }

    @When("user enters username as $uname")
    public void verifyEnteringValidUsername(String uname) {
        loginPage.enterUsername(uname);
    }

    @Then("user clicks on continue button")
    public void clickOnContinueButton() {
        loginPage.clickOnContinueButton();
    }

    @Then("user enters password as $password")
    public void enterPassword(String password) {
        loginPage.enterpassword(password);
        loginPage.clickOnSignInButton();
    }

    @Then("user should see error message after clicking on signin button")
    public void VerifyErrorMessageAfterprovidingInvalidPassword() {
        String errormessage = loginPage.seesErrorMessageForInvalidPassword();
        Assert.assertEquals("error message not matching, assertion failed", errormessage, "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");
    }

    @Then("user enters password and clicks on signin button")
    public void enterPasswordAndSignIn() {
        System.out.println(props.getProperty("password") + "password");
        loginPage.enterpassword(props.getProperty("password"));
        loginPage.clickOnSignInButton();
    }

    @Then("user should see user's name in accounts&lists section")
    public void verfifySuccessFulSignIn() {
        sessionStorage.storeCookies();
        Assert.assertEquals("username not matching", homePage.getSigninUsername(), "premsai");
    }

}
