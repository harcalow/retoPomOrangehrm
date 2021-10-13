package com.orangehrmlive.opensourcedemo.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CommonActionsOnPages {

    private WebDriver driver;
    //Explicit wait.
    private WebDriverWait webDriverExplicitWait;

    public CommonActionsOnPages(WebDriver driver) {
        this.driver = driver;
    }

    public CommonActionsOnPages(WebDriver driver, int seconds) {
        this.driver = driver;
        webDriverExplicitWaitConfiguration(this.driver, seconds);
    }

    public void clear(By webElement){
        driver.findElement(webElement).clear();
    }

    public void typeInto(By locator, CharSequence... keysToSend) throws IOException {
        driver.findElement(locator).sendKeys(keysToSend);
    }

    public void clickOn(By locator){
        driver.findElement(locator).click();
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }


    public boolean isDisplayed(By locator) throws NoSuchElementException {
        return driver.findElement(locator).isDisplayed();
    }

    //Configure the explicit wait.
    private void webDriverExplicitWaitConfiguration(WebDriver driver, int seconds){
            webDriverExplicitWait = new WebDriverWait(driver, seconds);
    }

}
