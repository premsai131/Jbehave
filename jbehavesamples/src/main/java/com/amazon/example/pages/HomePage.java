package com.amazon.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;

    private By accountsButton = By.cssSelector("[data-csa-c-content-id='nav_ya_signin']");
    private By signedinUsername = By.cssSelector("[id=\"nav-link-accountList-nav-line-1\"]");
    private By amazonLogo = By.cssSelector("[aria-label='Amazon']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnYourAccountsSignIn(){
        driver.findElement(accountsButton).click();
    }
    public boolean seesAmazonLogoInHomePage(){
        return driver.findElement(amazonLogo).isDisplayed();
    }
    public String  getSigninUsername(){
     String []name = driver.findElement(signedinUsername).getText().split(",");
     return name[1].trim();
    }
}
