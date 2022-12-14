package com.amazon.example.browsersetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
public static WebDriver driver;
public Properties props;
public BaseTest() throws IOException {
    props = new Properties();
    FileInputStream ip = new FileInputStream("/home/premst/Desktop/jbehavesample/jbehavesamples/src/main/java/com/amazon/example/stories/config.properties");
    props.load(ip);
}
public WebDriver  intialization(){
    String browser = props.getProperty("browser");
    if (browser.equals("chrome")) {
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        driver = new ChromeDriver(ChromeOptions);
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
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//    int wait = Integer.parseInt(System.getProperty("implicitwait"));
//    driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public static void close(){
    driver.close();
}
public static void quit(){
    driver.quit();
}
}
