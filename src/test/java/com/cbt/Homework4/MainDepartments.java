package com.cbt.Homework4;

import com.cbt.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {

    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
    }
    @Test
    public void allVerify(){
        driver.get("https://www.amazon.com/gp/site-directory");
        driver.manage().window().maximize();
        List<WebElement> allElements=driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
        List<String> allElementsText=new ArrayList<>();
        for (int i = 0; i < allElements.size()-1; i++) {
            allElementsText.add(allElements.get(i).getText());
        }


        List<WebElement> MainPageElements=driver.findElements(By.xpath("//div[@class='a-container fsdContainer fsdFullWidthImage']//div//div//div//h2"));
        List<String> MainPageElementsText=new ArrayList<>();
        for (int i = 0; i < MainPageElements.size()-1; i++) {
            MainPageElementsText.add(MainPageElements.get(i).getText());
        }

        System.out.println("\n"+allElementsText);
        System.out.println("\n"+MainPageElementsText);



        Assert.assertTrue(allElementsText.contains(MainPageElementsText));


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

