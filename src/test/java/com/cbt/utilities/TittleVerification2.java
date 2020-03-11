package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TittleVerification2 {
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

        driver.get(urls.get(1));
        Thread.sleep(2000);

        String title1 = driver.getTitle().replace(" ", "").toLowerCase();

        if (driver.getCurrentUrl().contains(title1)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("URL = " + driver.getCurrentUrl());
            System.out.println("TITLE = " + driver.getTitle());
        }

        driver.get(urls.get(2));
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains(driver.getTitle().replace(" ", "").toLowerCase())) {
            System.out.println("PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("URL = " + driver.getCurrentUrl());
            System.out.println("TITLE = " + driver.getTitle());
        }


        driver.get(urls.get(3));
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains(driver.getTitle().replace(" ", "").toLowerCase())) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("URL = " + driver.getCurrentUrl());
            System.out.println("TITLE = " + driver.getTitle());
        }

        Thread.sleep(2000);
        driver.quit();

    }
}
