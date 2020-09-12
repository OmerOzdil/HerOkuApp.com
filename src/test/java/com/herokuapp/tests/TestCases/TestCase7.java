package com.herokuapp.tests.TestCases;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 {


    // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. And click on “File Upload".
    // Step 3. Upload any file with .txt extension from your computer.
    // Step 4. Click “Upload” button.
    // Step 5. Verify that subject is: “File Uploaded!”
    // Step 6. Verify that uploaded file name is displayed.
    // Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
    // Run this method against “Choose File” button.

    @Test
    public void TC7(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='File Upload']")).click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        // send the file path.
        chooseFile.sendKeys("C:\\Users\\omero\\Desktop\\uploadfile.txt");

        driver.findElement(By.id("file-submit")).click();

        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(message.getText());

        //verify that message is displayed.
        Assert.assertTrue(message.isDisplayed());

        WebElement uploadFile = driver.findElement(By.id("uploaded-files"));
        System.out.println(uploadFile.getText());

        //verify that upload file name is displayed.
        Assert.assertTrue(uploadFile.isDisplayed());

        driver.quit();

    }
}
