package com.herokuapp.tests.TestCases;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 {

    @Test
    public void TC8(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();

        //locate the box
        WebElement myCountry = driver.findElement(By.id("myCountry"));

        myCountry.sendKeys("United States of America");

        //locate the submit button
        WebElement submitBUtton = driver.findElement(By.xpath("//input[@type='button']"));
        submitBUtton.click();

        //locate the message
        WebElement message = driver.findElement(By.id("result"));

        System.out.println(message.getText());
        //verify the message is displayed.
        Assert.assertTrue(message.isDisplayed());
        driver.quit();


    }
}
