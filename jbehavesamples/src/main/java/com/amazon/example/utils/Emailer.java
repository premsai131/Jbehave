package com.amazon.example.utils;

import org.apache.commons.mail.*;

import java.io.IOException;
import java.util.Properties;

public class Emailer {
    Properties props;
    public Emailer(Properties props) throws IOException {
        this.props = props;
    }
    public void sendNormalTextEmail() throws EmailException, IOException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        System.out.println(props.getProperty("username"));
        email.setAuthenticator(new DefaultAuthenticator(props.getProperty("username"), props.getProperty("apppassword")));
        email.setSSLOnConnect(true);
        email.setFrom("premsai@gmail.com");
        email.setSubject("TestMail from advanced selenium learnings");
        email.setMsg("This is a test mail ...triggered by commons email io for advanced selenium leanings :-)");
        email.addTo("ptippaluri@softility.com");
        email.send();
        System.out.println("Email has been sent successfully");
    }

    public void emailWithAttachment() throws EmailException {
        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("/var/lib/jenkins/workspace/pipelineJbehave/jbehavesamples/target/jbehave/com.amazon.example.stories.LoginPage.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("html report");
        attachment.setName("selenium report");
        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setSSLOnConnect(true);
//        email.setAuthenticator(new DefaultAuthenticator(props.getProperty("username"), props.getProperty("apppassword")));
        email.setAuthenticator(new DefaultAuthenticator(System.getProperty("gmailusername"), System.getProperty("gmailapppassword")));
        email.addTo("ptippaluri@softility.com", "premsai");
        email.setFrom(props.getProperty("username"), "premsai");
        email.setSubject("jbehave sample test");
        email.setMsg("attached reports of jbehave sample tests  ");
        email.attach(attachment);
        email.send();
    }
    public void testprops(){
        System.out.println(props.getProperty("username")+"props working fine");
    }
//    public static void main(String args[]) throws EmailException, IOException {
//        Emailer sendemail = new Emailer(new Properties());
//        sendemail.emailWithAttachment();
//    }
}
