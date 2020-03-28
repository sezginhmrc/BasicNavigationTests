package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver createADriver(String browser ){



            if(browser.equalsIgnoreCase("chrome")){
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
        } else if (browser.equalsIgnoreCase("edge")){
            return null ;
        } else {
                throw  new WebDriverManagerException("INVALID BROWSER");
            }
    }
}
