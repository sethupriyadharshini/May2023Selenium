package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaleElementReferenceExample {

    public static WebDriver driver;
    public static void waitMethod(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(locator)));
        driver.findElement(locator).sendKeys("completed");
    }

    public static void waitMethod2(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(locator)));
        driver.findElement(locator).click();
    }
    public static void main(String[] args){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        By search_click = By.linkText("Table Data Search");
        WebElement search1_click = driver.findElement(search_click);
        search1_click.click();
        By filter = By.id("task-table-filter");
        WebElement filter1 = driver.findElement(filter);
        filter1.sendKeys("in progress");
        driver.navigate().back();
        waitMethod2(search_click);
        waitMethod(filter);
        //search_click.click();
        //filter.sendKeys("in progress");
    }

}
