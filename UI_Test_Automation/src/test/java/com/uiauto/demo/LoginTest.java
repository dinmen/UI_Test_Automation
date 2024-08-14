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
    private String userNameStr = "standard_user";
    private String passwordStr = "secret_sauce";
    private String uri = "https://www.saucedemo.com/";

    @Test(priority = 1)
    public void validLoginTestWithoutPageObjectModel() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        System.out.println("Type attribute " + submitButton.getAttribute("type"));
        System.out.println("ID attribute " + submitButton.getAttribute("id"));
        System.out.println("Name attribute " + submitButton.getAttribute("name"));

        userName.sendKeys(userNameStr);
        Thread.sleep(1000);
        password.sendKeys(passwordStr);
        Thread.sleep(1000);
        submitButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test(priority = 2)
    public void validLoginTestWithPageObjectModel() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userNameStr, passwordStr);

        Thread.sleep(5000);
        driver.quit();
    }

    @Test(priority = 3)
    public void validLoginTestWithPOMAndHomePage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(userNameStr, passwordStr);

        Thread.sleep(5000);
        Assert.assertTrue(homePage.verifyHomePage(), "User is not navigated to the Home Page");

        driver.quit();
    }

    @Test(priority = 4)
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

    @Test(priority = 5)
    public void verifyLoginWithValidUnAndInvalidPW() throws InterruptedException {
        String validUserNameStr = "standard_user";
        String invalidPasswordStr = "123";

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(validUserNameStr, invalidPasswordStr);

        Thread.sleep(5000);
        Assert.assertTrue(loginPage.invalidLogin(), "User successfully logged into the system");

        driver.quit();
    }

    @Test(priority = 6)
    public void verifyLoginWithInvalidUnAndInvalidPW() throws InterruptedException {
        String invalidUserNameStr = "!@#$";
        String invalidPasswordStr = "123";

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(invalidUserNameStr, invalidPasswordStr);

        Thread.sleep(5000);
        Assert.assertTrue(loginPage.invalidLogin(), "User successfully logged into the system");

        driver.quit();
    }

    @Test(priority = 7)
    public void verifyLoginWithEmptyUnAndEmptyPW() throws InterruptedException {
        String emptyUserNameStr = "";
        String emptyPasswordStr = "";

        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(emptyUserNameStr, emptyPasswordStr);

        Thread.sleep(5000);
        Assert.assertTrue(loginPage.invalidLogin(), "User successfully logged into the system");

        driver.quit();
    }

}
