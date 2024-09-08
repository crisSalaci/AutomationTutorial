package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabWindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browserul maximise
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()= 'Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertFrameWindowMenu);

        WebElement browserWindowElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementMethods.clickJSElement(browserWindowElement);

        WebElement newTabElement=driver.findElement(By.id("tabButton"));
        elementMethods.clickJSElement(newTabElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowElement=driver.findElement(By.id("windowButton"));
        elementMethods.clickJSElement(newWindowElement);

        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();

        driver.quit();
    }
}