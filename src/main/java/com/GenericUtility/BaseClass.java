package com.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void lounchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
