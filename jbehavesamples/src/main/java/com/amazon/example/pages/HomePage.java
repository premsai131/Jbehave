package com.amazon.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;

    private By accountsButton = By.cssSelector("[data-csa-c-content-id='nav_ya_signin']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnYourAccountsSignIn(){
        driver.findElement(accountsButton).click();
    }
}
