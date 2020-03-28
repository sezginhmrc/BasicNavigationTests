package com.cbt.Homework4;

import com.cbt.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Todays_Date {

    private WebDriver driver ;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        if(driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
 }

    @Test ( description = "TEST 2", priority = 1)
    public void year() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        String actual = driver.findElement(By.id("year")).getAttribute("value");
        String expected = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY"));
        Assert.assertEquals(actual, expected);
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

    }
    @Test (description = "TEST 2",priority = 2)
    public void  month(){
        driver.get("http://practice.cybertekschool.com/dropdown");


        Select select = new Select(driver.findElement(By.id("month")));

        String actualMonth = select.getFirstSelectedOption().getText();

        String expectedMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
        System.out.println(actualMonth);
        System.out.println(expectedMonth);
        Assert.assertEquals(actualMonth,expectedMonth);

    }
    @Test (description = "TEST 2",priority = 3)
    public void day() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select day = new Select(driver.findElement(By.id("day")));
        String actualDay = day.getFirstSelectedOption().getText();
        String expextedDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
        System.out.println(expextedDay);
        System.out.println(actualDay);
        Assert.assertEquals(actualDay,expextedDay);

    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
