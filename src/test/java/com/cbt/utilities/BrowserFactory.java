package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser ){


        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("mac")&& browser.equalsIgnoreCase("edge")) {
            return null;
        }  else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
           return   new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")){
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        } else  if (browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        } else if (browser.equalsIgnoreCase("safari")){
            return  new SafariDriver();
        } else {
            return null ;
        }
    }


}
