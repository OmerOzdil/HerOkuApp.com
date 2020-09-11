package com.herokuapp.tests.TCfrom1to5;

import com.herokuapp.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
    @Test
    public void TC2(){
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. Click on “Registration Form”
        // Step 3. Verify that following options for programming languages are displayed:
        // c++, java, JavaScript

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regsButton = driver.findElement(By.xpath("//a[.='Registration Form']"));
        // click the button.
        regsButton.click();

        //C++ checkbox
        WebElement coption = driver.findElement(By.xpath("//*[.='C++']"));
        WebElement javaOption = driver.findElement(By.xpath("//*[.='Java']"));
        WebElement javaScriptOption = driver.findElement(By.xpath("//*[.='JavaScript']"));

        Assert.assertTrue(coption.isDisplayed());
        Assert.assertTrue(javaOption.isDisplayed());
        Assert.assertTrue(javaScriptOption.isDisplayed());

        /*
       List<WebElement> options = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));

        for (WebElement each: options) {
            Assert.assertTrue(each.isDisplayed());

        }

         */
    }
    @Test
    public void TC3(){

        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. Click on “Registration Form”
        // Step 3. Enter only one alphabetic character into first name input box.
        // Step 4. Verify that warning message is displayed:
        // “first name must be more than 2 and less than 64 characters long”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regsButton = driver.findElement(By.xpath("//a[.='Registration Form']"));
        // click the button.
        regsButton.click();

        //locate firstNameBox
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstNameBox.sendKeys("O");

        //locate the text
        WebElement text = driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']"));

        //WebDriverWait wait = new WebDriverWait(driver,3);

        //wait.until(ExpectedConditions.visibilityOf(text));
        //verify that text is displayed
        Assert.assertTrue(text.isDisplayed());
    }
    @Test
    public void TC4(){
        // Step 1. Go to https://practice-cybertekschool.herokuapp.com
        // Step 2. Click on “Registration Form”
        // Step 3. Enter only one alphabetic character into last name input box.
        // Step 4. Verify that warning message is displayed:
        // “The last name must be more than 2 and less than 64 characters long”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regsButton = driver.findElement(By.xpath("//a[.='Registration Form']"));
        // click the button.
        regsButton.click();

        //locate the lastNameBox
        WebElement lastNameBox = driver.findElement(By.cssSelector("[name='lastname']"));

        lastNameBox.sendKeys("O");

        // locate the text
        WebElement text = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']"));

        //verify that text is displayed

        Assert.assertTrue(text.isDisplayed());

    }
    @Test
    public void TC5() throws InterruptedException {
        // Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        // Step 2. Click on “Registration Form”
        // Step 3. Enter any valid first name.
        // Step 4. Enter any valid last name.
        // Step 5. Enter any valid user name.
        // Step 6. Enter any valid password.
        // Step 7. Enter any valid phone number.
        // Step 8. Select gender.
        // Step 9. Enter any valid date of birth.
        // Step 10. Select any department.
        // Step 11. Enter any job title.
        // Step 12. Select java as a programming language.
        // Step 13. Click Sign up.
        // Step 14. Verify that following success message is displayed:
        // “You've successfully completed registration!”

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement regsButton = driver.findElement(By.xpath("//a[.='Registration Form']"));
        // click the button.
        regsButton.click();

        //locate firstNameBox
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("Omer");

        //locate the lastNameBox
        WebElement lastNameBox = driver.findElement(By.cssSelector("[name='lastname']"));
        lastNameBox.sendKeys("Ozdil");

        //locate the username
        WebElement usernameBox = driver.findElement(By.cssSelector("[name='username']"));
        usernameBox.sendKeys("AliVeli");

        //locate the emailBox
        WebElement emailBox = driver.findElement(By.cssSelector("[name='email']"));
        emailBox.sendKeys("omer@gmail.com");

        //locate the password
        WebElement passwordBox = driver.findElement(By.xpath("//*[@name='password']"));
        passwordBox.sendKeys("VeliAli123");

        //locate the phone
        WebElement phoneBox = driver.findElement(By.cssSelector("[name='phone']"));
        phoneBox.sendKeys("571-987-8976");

        //locate the male radio button
        WebElement maleRadioButton = driver.findElement(By.cssSelector("[value='male']"));
        maleRadioButton.click();

        //locate the dob box
        WebElement dob = driver.findElement(By.cssSelector("[name='birthday']"));
        dob.sendKeys("5/03/1986");

        // Enter a department
        WebElement departmentDropDown = driver.findElement(By.cssSelector("[name='department']"));
        Select options = new Select(departmentDropDown);
        options.selectByValue("TRO");
        //System.out.println(options.getFirstSelectedOption().getText());
        options.getFirstSelectedOption().click();



        //Enter a job Title
        WebElement jobTitleDropDown = driver.findElement(By.cssSelector("[name='job_title']"));
        //create a select object to interact with options easily
        Select optionsJT = new Select(jobTitleDropDown);
        optionsJT.selectByIndex(2);
        //System.out.println(options.getFirstSelectedOption().getText());
        optionsJT.getFirstSelectedOption().click();

        // locate the Java language
        WebElement Java = driver.findElement(By.cssSelector("[for='inlineCheckbox2']"));
        Java.click();

        // locate the signUp button
        WebElement signUpButton = driver.findElement(By.id("wooden_spoon"));
        signUpButton.click();

        //locate the message
        WebElement message = driver.findElement(By.xpath("//p"));

        System.out.println(message.getText());

        Assert.assertTrue(message.isDisplayed());


    }
}
