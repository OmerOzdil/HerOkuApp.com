package com.herokuapp.tests.TestCases;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases9to12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void close(){

        driver.quit();
    }
    @Test
    public void TC9() throws InterruptedException {
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “200”.
        // Step 4. Verify that following message is displayed:
        // “This page returned a 200 status code”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement status_codes = driver.findElement(By.linkText("Status Codes"));

        status_codes.click();

        //locate the 200
        WebElement element = driver.findElement(By.linkText("200"));
        element.click();

        //locate the message
        WebElement message = driver.findElement(By.tagName("p"));

        String expectedMessage="This page returned a 200 status code";
        String actualMessage =message.getText();
        System.out.println(actualMessage);

        //verify that message is displayed
        Assert.assertTrue(message.isDisplayed());

        //verify the content of the message
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void TC10(){

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “301”.
        // Step 4. Verify that following message is displayed:
        // “This page returned a 301 status code”


        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement status_codes = driver.findElement(By.linkText("Status Codes"));

        status_codes.click();

        //locate the 301
        WebElement element = driver.findElement(By.linkText("301"));
        element.click();

        //locate the message
        WebElement message = driver.findElement(By.tagName("p"));

        String expectedMessage="This page returned a 301 status code";
        String actualMessage = message.getText();
        System.out.println(actualMessage);

        //verify that message is displayed
        Assert.assertTrue(message.isDisplayed());

        //verify the content of the message
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    public void TC11(){

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “404”.
        // Step 4. Verify that following message is displayed:
        // “This page returned a 404 status code”


        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement status_codes = driver.findElement(By.linkText("Status Codes"));

        status_codes.click();

        //locate the 404
        WebElement element = driver.findElement(By.linkText("404"));
        element.click();

        //locate the message
        WebElement message = driver.findElement(By.tagName("p"));

        String expectedMessage="This page returned a 404 status code";
        String actualMessage = message.getText();
        System.out.println(actualMessage);

        //verify that message is displayed
        Assert.assertTrue(message.isDisplayed());

        //verify the content of the message
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    public void TC12(){

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. And click on “Status Codes”.
        // Step 3. Then click on “500”.
        // Step 4. Verify that following message is displayed:
        // “This page returned a 500 status code”


        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement status_codes = driver.findElement(By.linkText("Status Codes"));

        status_codes.click();

        //locate the 500
        WebElement element = driver.findElement(By.linkText("500"));
        element.click();

        //locate the message
        WebElement message = driver.findElement(By.tagName("p"));

        String expectedMessage="This page returned a 500 status code";
        String actualMessage = message.getText();
        System.out.println(actualMessage);

        //verify that message is displayed
        Assert.assertTrue(message.isDisplayed());

        //verify the content of the message
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

}
