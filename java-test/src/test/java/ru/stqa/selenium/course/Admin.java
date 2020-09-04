package ru.stqa.selenium.course;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
    private WebDriver webDriver;
    private WebDriverWait driverWait;

    @Before
    public void start() {
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, 10);
    }

    @Test
    public void autorization() {
        webDriver.get("http://localhost/litecart/admin/");

        webDriver.findElement(By.name("username")).sendKeys("admin");
        webDriver.findElement(By.name("password")).sendKeys("admin");
        webDriver.findElement(By.name("login")).click();
        driverWait.until(ExpectedConditions.titleIs("My Store"));
    }

    @After
    public void close() {
        webDriver.quit();
        webDriver = null;
    }
}

