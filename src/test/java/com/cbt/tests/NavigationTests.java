package com.cbt.tests;

import com.cbt.utilities.DriverFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NavigationTests {

    public static void main(String[] args) throws Exception {


        //chromeTest();
        // firefoxTest();
           safariText();
    }

    @Test
    public static void safariText() throws Exception {


        WebDriver driver = DriverFactory.createADriver("safari");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        Thread.sleep(2000);
        String title1 = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(2000);
        String expected = title;
        StringUtility.verifyEquals(expected, driver.getTitle());
        driver.navigate().forward();
        Thread.sleep(2000);
        String expexted1 = title1;
        StringUtility.verifyEquals(expexted1, driver.getTitle());
        driver.close();
    }

    @Test
    public static void firefoxTest() throws Exception {


        WebDriver driver = DriverFactory.createADriver("firefox");
        driver.get("https://google.com");

        String title = driver.getTitle();
        Thread.sleep(2000);

        driver.navigate().to("https://etsy.com");
        String tittle1 = driver.getTitle();

        driver.navigate().back();
        Thread.sleep(2000);

        String expectedTitle = title;

        StringUtility.verifyEquals(expectedTitle, driver.getTitle());


        driver.navigate().forward();
        Thread.sleep(2000);

        String expectedTitle1 = tittle1;

        StringUtility.verifyEquals(expectedTitle1, driver.getTitle());

        driver.close();
    }

    @Test
    public static void chromeTest() throws Exception {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("https://google.com");

        String title = driver.getTitle();
        Thread.sleep(2000);

        driver.navigate().to("https://etsy.com");
        String tittle1 = driver.getTitle();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        String actualTittle = driver.getTitle();
        String expectedTittle = title;

        StringUtility.verifyEquals(expectedTittle,actualTittle);

        driver.navigate().forward();
        Thread.sleep(2000);

        String actualTittle1 = driver.getTitle();
        String expectedTittle1 = tittle1;

        StringUtility.verifyEquals(expectedTittle1, actualTittle1);

        driver.close();
    }

}