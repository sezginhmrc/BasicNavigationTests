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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Years_Months_Days {

    private WebDriver driver;

    @BeforeMethod
   public void setup() {
        driver = DriverFactory.createADriver("chrome");
        if(driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @Test
    public void test(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select y = new Select(year);
        Select m = new Select(month);
        Select d = new Select(day);
        Random r = new Random();
        int index = r.nextInt(y.getOptions().size());
        y.selectByIndex(index);
        List<String> months31 = new ArrayList<>(Arrays.asList(new String[]{"January", "March", "May", "July", "August", "October", "December"}));
        int febDays;
        int yearValue = Integer.parseInt(y.getFirstSelectedOption().getText());
        if(yearValue %400==0 || (yearValue%4 ==0 && yearValue %100!=0)){
            febDays=29;
        }else{
            febDays=28;
        }
        for(int i =0; i<12; i++){
            m.selectByIndex(i);
            if(months31.contains(m.getFirstSelectedOption().getText())){
                Assert.assertEquals(d.getOptions().size(), 31);
            }else if(m.getFirstSelectedOption().getText().equals("February")){
                Assert.assertEquals(d.getOptions().size(), febDays);
            }else{
                Assert.assertEquals(d.getOptions().size(), 30);
            }
        }


    }


    @AfterMethod
    public void tear(){
       driver.quit();
    }
}
