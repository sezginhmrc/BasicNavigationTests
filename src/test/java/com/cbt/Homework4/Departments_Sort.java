package com.cbt.Homework4;

import com.cbt.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Departments_Sort {

    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @Test
    public void test(){

        driver.get("https://www.amazon.com");
      //  Select select = new Select(driver.findElement(By.xpath("//span[@class='nav-search-label']")));

        //verify that defaul tvalue of the All departmentsdropdown is All
       //  String actual = driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();
       // String expected = "All" ;

       //  Assert.assertEquals(actual,expected);

        //verify that defaul tvalue of the All departmentsdropdown is All
       /* String actual =   select.getFirstSelectedOption().getText().substring(0,4).trim();
        String expected = "All" ;
        Assert.assertEquals(actual,expected);*/

       Assert.assertEquals(driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText(),"All");


       //verify that options are not sorted

       Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> alloptionsDefault = select.getOptions();
        // defaults options

        boolean notSorted = false ;
        for (int i = 0; i <alloptionsDefault.size()-1 ; i++) {
            if(alloptionsDefault.get(i).getText().compareTo(alloptionsDefault.get(i+1).getText())>0){
                notSorted=true;
                break;
            }
        }
        Assert.assertTrue(notSorted);












    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
