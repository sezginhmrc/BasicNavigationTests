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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main_Departments {

    private WebDriver driver ;

    @BeforeMethod
    public void setup() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        driver = DriverFactory.createADriver("chrome");
    }


    @Test
    public void test() {

        driver.get("https://www.amazon.com/gp/site-directory");

        Select select = new Select(driver.findElement(By.cssSelector("select[name='url']")));
        List<WebElement> allOptions = select.getOptions();


        List<String> list1 = new ArrayList<>();
        for (WebElement each : allOptions) {
            list1.add(each.getText());
        }

        List<WebElement> allTittles = driver.findElements(By.cssSelector("div[class='fsdDeptBox'] > h2"));


        List<String> list2 = new ArrayList<>();
        for (WebElement blues : allTittles) {
            list2.add(blues.getText());
        }

          for (String each : list2){
            if(!list1.contains(each)){
              System.out.println(each);
            System.out.println("This all tittles is not in all options");
         }
  }


        System.out.println(list1);
        System.out.println(list2);
        // Acceptance Criteria Specification ?

        Assert.assertTrue(list1.containsAll(list2));

    }




        @AfterMethod
     public void teardown(){
        driver.close();
    }
}


