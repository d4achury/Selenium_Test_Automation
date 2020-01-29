package com.packen.BrowserManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserInteractor {

    private WebDriver webDriver ;
    private static BrowserInteractor browserManagementInstance ;
    private WebDriverWait waiter;

    public static synchronized BrowserInteractor getInstance() throws Exception {
        if (browserManagementInstance == null) {
            browserManagementInstance = new BrowserInteractor();
        }
        return browserManagementInstance;
    }

    private BrowserInteractor() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        this.webDriver = new ChromeDriver();
        this.waiter = new WebDriverWait(this.webDriver,10);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static void waitForPageToLoad(WebDriver webDriver,String nextXpath){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextXpath)));
    }

}
