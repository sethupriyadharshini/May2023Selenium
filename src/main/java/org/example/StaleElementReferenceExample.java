package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceExample {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement search_click = driver.findElement(By.linkText("Table Data Search"));
        search_click.click();
        WebElement filter = driver.findElement(By.id("task-table-filter"));
        filter.sendKeys("in progress");
        driver.navigate().back();
        search_click.click();
        filter.sendKeys("in progress");
    }

}
