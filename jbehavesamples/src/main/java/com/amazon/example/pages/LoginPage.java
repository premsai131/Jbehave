package com.amazon.example.pages;

import com.amazon.example.browsersetup.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BaseTest {
   public WebDriver driver;
    private By amazonLogo = By.cssSelector("[aria-label=\"Amazon\"]");
    private By signInText = By.xpath("//h1[contains(text(),'Sign in')]");
    private By emailInputField = By.cssSelector("[id='ap_email']");
    private By continueButton = By.cssSelector("[id='continue']");
    private By invlaidAccountErrorMessageText = By.cssSelector("ul>li>span");
    private By passwordinputField = By.cssSelector("[id='ap_password']");
    private By signinButton = By.cssSelector("[id=\"signInSubmit\"]");


    public LoginPage(WebDriver driver) throws IOException {
       this.driver = driver;
    }
    public boolean seesAmazonLogo(){
        boolean islogoVisible = driver.findElement(amazonLogo).isDisplayed();
        return islogoVisible;
    }
    public boolean seesSignInText(){
        boolean isSigninTextVisible = driver.findElement(signInText).isDisplayed();
        return  isSigninTextVisible;
    }
    public void enterUsername(String uname){
        driver.findElement(emailInputField).clear();
        driver.findElement(emailInputField).sendKeys(uname);
    }
    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String seesErrorMessageForInvalidEmail(){
        return driver.findElement(invlaidAccountErrorMessageText).getText();
    }
    public void enterpassword(String password){
        driver.findElement(passwordinputField).clear();
        driver.findElement(passwordinputField).sendKeys(password);
    }
    public void clickOnSignInButton(){
        driver.findElement(signinButton).click();
    }
    public String seesErrorMessageForInvalidPassword(){
      return driver.findElement(invlaidAccountErrorMessageText).getText();
    }
}
