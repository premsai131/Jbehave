package com.amazon.example.hooks;


import com.amazon.example.browsersetup.BaseTest;
import com.amazon.example.utils.Emailer;
import org.apache.commons.mail.EmailException;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;


import java.io.IOException;

public class ApplicationHooks extends BaseTest {
    private Emailer email;
    private ApplicationHooks hooks;
    private BaseTest baseTest;
    private String reportdir = "/home/premst/Desktop/jbehavesample/jbehavesamples/target";

    public ApplicationHooks() throws IOException {
        super();
    }
    @BeforeStories
    public void cleanReports() throws IOException {
//        FileUtils.cleanDirectory("/jbehavesamples/target/");
//
////        FileUtils.deleteDirectory(new File("/jbehavesamples/target/jbehave"));
//        System.out.println("before stories");

    }
    @AfterStories(order = 1)
    public void quitBrowserSession() throws IOException {
        System.out.println("after stories 0 ");
        baseTest = new BaseTest();
        baseTest.close();
        baseTest.quit();
    }
    @AfterStories(order = 0)
    public void sendreport() throws EmailException, IOException {
        System.out.println("after stories 1");
        ApplicationHooks hooks = new ApplicationHooks();
        email = new Emailer(props);
        email.emailWithAttachment();
    }
}
//    @BeforeStory
//    public void setup() throws IOException, InterruptedException {
//        baseTest = new BaseTest();
//       driver = baseTest.intialization();
//        homePage = new HomePage(driver);
//    }
//    @BeforeScenario
//    public void clickOnSignInPage() throws IOException, InterruptedException {
//        baseTest.visitWebsite();
//        homePage.clickOnYourAccountsSignIn();
//    }



