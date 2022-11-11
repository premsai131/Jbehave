package com.amazon.example.utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class SessionStorage  {
    private File file;
    private WebDriver driver;

    public SessionStorage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void storeCookies(){
        file = new File("Cookies.data");
        try
        {
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for(Cookie ck : driver.manage().getCookies())
            {
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void readCookies() throws InterruptedException {
            try{
                File file = new File("Cookies.data");
                FileReader fileReader = new FileReader(file);
                BufferedReader Buffreader = new BufferedReader(fileReader);
                String strline;
                while((strline=Buffreader.readLine())!=null){
                    StringTokenizer token = new StringTokenizer(strline,";");
                    while(token.hasMoreTokens()){
                        String name = token.nextToken();
                        String value = token.nextToken();
                        String domain = token.nextToken();
                        String path = token.nextToken();
                        Date expiry = null;
                        String val;
                        Date currentdate =null;
                        if(!(val=token.nextToken()).equals("null"))
                        {
                            SimpleDateFormat sdf=new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
                            currentdate=sdf.parse(val);
//                        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd hh:mm:ss");
//                        expiry = sdf.parse(val);
                        }
                        Boolean isSecure = new Boolean(token.nextToken()).
                                booleanValue();
                        Cookie ck = new Cookie(name,value,domain,path,currentdate,isSecure);
                        System.out.println(ck);
                        driver.manage().addCookie(ck);
                    }
                }
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            Thread.sleep(3000);
            driver.navigate().refresh();
    }

}
