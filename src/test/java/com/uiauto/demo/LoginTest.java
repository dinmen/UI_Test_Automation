package com.uiauto.demo;

import com.uiauto.demo.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.Test;

public class LoginTest {
    //valid user name "standard_user";
    //valid password "secret_sauce";

    private String uri = "https://www.saucedemo.com/";

    @Test(priority = 1)
    public void verifyLoginWithInvalidUnAndValidPW() throws InterruptedException {
        String invalidUserNameStr = "!@#$";
        String validPasswordStr = "secret_sauce";

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(invalidUserNameStr, validPasswordStr);

        Thread.sleep(5000);
        Assert.assertTrue(loginPage.invalidLogin(), "User successfully logged into the system");

        driver.quit();
    }

    @Test(priority = 2)
    public void verifyLoginWithValidUnAndInvalidPW() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);



        Thread.sleep(5000);


        driver.quit();
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidUnAndInvalidPW() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);



        Thread.sleep(5000);


        driver.quit();
    }

    @Test(priority = 4)
    public void verifyLoginWithEmptyUnAndEmptyPW() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);



        Thread.sleep(5000);


        driver.quit();
    }

}
