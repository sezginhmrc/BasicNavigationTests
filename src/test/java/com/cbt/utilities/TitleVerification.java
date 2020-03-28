package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.*;

public class TitleVerification {

    public static void main(String[] args)throws Exception {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");



        WebDriver driver = DriverFactory.createADriver("chrome");

        List<String> titles = new ArrayList<>();

        for (String eachUrl : urls){
            driver.get(eachUrl);
            titles.add(driver.getTitle());
        }
        System.out.println(titles);

        for (int i = 0; i <titles.size()-1 ; i++) {
            StringUtility.verifyEquals(titles.get(i),titles.get(i+1));
            // checked tittles 0,1 ,1,2
        }
        StringUtility.verifyEquals(titles.get(0),titles.get(2));
        // checked 0,2
        // covered all combinations


        for (String allUrl : urls){
            if(allUrl.startsWith("http://practice.cybertekschool.com")){
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }

       driver.close();
    }
}
