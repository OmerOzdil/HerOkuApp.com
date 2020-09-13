package com.herokuapp.tests.TestCases;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {
    @Test
    public void TC6() throws InterruptedException {

        // Step 1. Go to "https://www.tempmailaddress.com/"
        // Step 2. Copy and save email as a string.
        // Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        // Step 4. And click on “Sign Up For Mailing List".
        // Step 5. Enter any valid name.
        // Step 6. Enter email from the Step 2.
        // Step 7. Click Sign Up
        // Step 8. Verify that following message is displayed:
        // “Thank you for signing up. Click the button below to return to the home page.”
        // Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        // Step 10. Verify that you’ve received an email from
            // “do-not-reply@practice.cybertekschool.com”
        // Step 11. Click on that email to open it.
        // Step 12. Verify that email is from:
            // “do-not-reply@practice.cybertekschool.com”
        // Step 13. Verify that subject is:
            //  “Thanks for subscribing to practice.cybertekschool.com!”

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tempmailaddress.com/");

        //locate the email box
        WebElement email = driver.findElement(By.xpath("//span[@id='email']"));
        String fullemail = email.getText();

        // go to the
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //locate the sign up session
        WebElement signUpEmail = driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']"));
        signUpEmail.click();

        //locate the fullName box
        WebElement fullNameBox = driver.findElement(By.xpath("//input[@name='full_name']"));
        fullNameBox.sendKeys("Omer");

        //locate the email box
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(fullemail);

        //locate the sign up button
        WebElement signUpButton = driver.findElement(By.tagName("button"));
        signUpButton.click();

        //locate the message
        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(message.getText());
        Assert.assertTrue(message.isDisplayed());


        driver.navigate().to("https://www.tempmailaddress.com/");

        Thread.sleep(5000);

        //locate fakeemail to open
        WebElement fakeemail = driver.findElement(By.xpath("//*[.='do-not-reply@practice.cybertekschool.com']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println(fakeemail.isDisplayed());

        jse.executeScript("arguments[0].click();",fakeemail);

//        System.out.println(fakeemail.isDisplayed());
//        fakeemail.click();

        //locate the sender
        WebElement sender = driver.findElement(By.id("odesilatel"));
        System.out.println(sender.getText());
        //verification
        Assert.assertTrue(sender.isDisplayed());

        //locate the subject
        WebElement subject = driver.findElement(By.id("predmet"));
        System.out.println(subject.getText());
        Assert.assertTrue(subject.isDisplayed());


    }
}
