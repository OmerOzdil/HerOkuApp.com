package com.herokuapp.tests.TCfrom1to5;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases1to5 {

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
    public void TC1(){
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. Click on “Registration Form”
        // Step 3. Enter “wrong_dob” into date of birth input box.
        // Step 4. Verify that warning message is displayed:
              // “The date of birth is not valid”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regsButton = driver.findElement(By.xpath("//a[.='Registration Form']"));
        // click the button.
        regsButton.click();

        WebElement dobBox = driver.findElement(By.cssSelector("input[name='birthday']"));

        //send a wrong dob
        dobBox.sendKeys("090");

        WebElement text = driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));

        // verify that text is appeared
        Assert.assertTrue(text.isDisplayed(),"verify that text is appeared");





    }
}
