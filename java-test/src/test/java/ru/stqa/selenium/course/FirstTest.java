package ru.stqa.selenium.course;

import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    private WebDriver webDriver;
    private WebDriverWait driverWait;

    @Before
    public void start() {
        webDriver = new ChromeDriver();
        driverWait = new WebDriverWait(webDriver, 10);
    }

    @Test
    public void myFirstClass() {
        webDriver.get("http://www.google.com");
        webDriver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driverWait.until(ExpectedConditions.titleIs("Selenium WebDriver - Поиск в Google"));
    }

    @After
    public void close() {
        webDriver.quit();
        webDriver = null;
    }
}

