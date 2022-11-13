package com.amazon.example.browsersetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
public WebDriver driver;
public Properties props;
public BaseTest() throws IOException {
    props = new Properties();
    FileInputStream ip = new FileInputStream("/home/premst/Desktop/jbehavesample/jbehavesamples/src/main/java/com/amazon/example/stories/config.properties");
    props.load(ip);
}
public WebDriver  intialization(){
    String browser = props.getProperty("browser");
    if (browser.equals("chrome")) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    } else if (browser.equals("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    } else {
        System.out.println("invalid browser name");
    }
    return driver;
}
public void visitWebsite() throws InterruptedException {
    String url = props.getProperty("url");
    driver.get(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void close(){
    driver.close();
}
public void quit(){
    driver.quit();
}
}
