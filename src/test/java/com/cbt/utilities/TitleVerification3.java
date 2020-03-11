package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws Exception {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                "http://wayfair.com", "http://walmart.com", "http://westelm.com");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        Thread.sleep(2000);
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        title = title.replace(" ", "").toLowerCase();

        if (url.contains(title)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        WebDriver driver1 = BrowserFactory.getDriver("chrome");
        driver1.get(urls.get(1));
        Thread.sleep(2000);

        String title1 = driver1.getTitle().replace(" ", "").toLowerCase();

        if (driver1.getCurrentUrl().contains(title1)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("URL = " + driver1.getCurrentUrl());
            System.out.println("TITLE = " + driver1.getTitle());
        }

        WebDriver driver2 = BrowserFactory.getDriver("chrome");
        driver2.get(urls.get(2));
        Thread.sleep(2000);
        if (driver2.getCurrentUrl().contains(driver2.getTitle().replace(" ", "").toLowerCase())) {
            System.out.println("PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("URL = " + driver2.getCurrentUrl());
            System.out.println("TITLE = " + driver2.getTitle());
        }

        WebDriver driver3 = BrowserFactory.getDriver("chrome");
        driver3.get(urls.get(3));
        Thread.sleep(2000);
        if (driver3.getCurrentUrl().contains(driver3.getTitle().replace(" ", "").toLowerCase())) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("URL = " + driver3.getCurrentUrl());
            System.out.println("TITLE = " + driver3.getTitle());
        }

    }
}
