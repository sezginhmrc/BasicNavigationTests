package com.cbt.Homework4;

import com.cbt.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {

    private WebDriver driver ;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public  void test1(){

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//label"));
        int countFriday = 0 ;
        Random random = new Random();

        while(countFriday!=3){
            int index = random.nextInt(checkboxes.size());
            if(checkboxes.get(index).isEnabled()){
                checkboxes.get(index).click();
                if (labels.get(index).getText().equals("Friday")){
                    countFriday++ ;
                }
                System.out.println(checkboxes.get(index).getAttribute("id").split("-")[3]);
                checkboxes.get(index).click();
            }
        }
        Assert.assertEquals(countFriday,3);


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}






