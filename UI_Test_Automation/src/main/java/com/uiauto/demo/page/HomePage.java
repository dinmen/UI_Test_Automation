package com.uiauto.demo.page;

import org.openqa.selenium.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.manager.*;

import java.util.logging.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyHomePage() {
        try {
            WebElement lblProducts = driver.findElement(By.className("title"));
            if (lblProducts.isDisplayed()) {
                return true;
            }
        } catch(Exception e) {
            System.out.println("Exception thrown");
        }

        return false;
    }







}
