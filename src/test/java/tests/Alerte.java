package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alerte {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browserul maximise
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()= 'Alerts, Frame & Windows']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", alertFrameWindowMenu);
        elementMethods.clickJSElement(alertFrameWindowMenu);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        js.executeScript("arguments[0].click();", alertsElement);
        elementMethods.clickJSElement(alertsElement);

        WebElement okAlert=driver.findElement(By.id("alertButton"));
//        js.executeScript("arguments[0].click();", okAlert);
        elementMethods.clickJSElement(okAlert);

//        Alert firstAlert=driver.switchTo().alert();
//        System.out.println(firstAlert.getText());
//        firstAlert.accept();
        alertMethods.acceptAlert();

        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
//        js.executeScript("arguments[0].click();", timerAlertButtonElement);
        elementMethods.clickJSElement(timerAlertButtonElement);


        //wait explicit
//        WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
//        waitExplicit.until(ExpectedConditions.alertIsPresent());

//        Alert secondAlert=driver.switchTo().alert();
//        System.out.println(secondAlert.getText());
//        secondAlert.accept();
        alertMethods.acceptAlert();

        WebElement confirmAlert=driver.findElement(By.id("confirmButton"));
//        js.executeScript("arguments[0].click();", confirmAlert);
        elementMethods.clickJSElement(confirmAlert);

//        Alert thirdAlert=driver.switchTo().alert();
//        System.out.println(thirdAlert.getText());
//        thirdAlert.dismiss();
        alertMethods.dismissAlert();

        WebElement alertPrompt=driver.findElement(By.id("promtButton"));
        //alertPrompt.click();
//        js.executeScript("arguments[0].click();", alertPrompt);
        elementMethods.clickJSElement(alertPrompt);

        Alert fourthAlert=driver.switchTo().alert();
        System.out.println(fourthAlert.getText());
        fourthAlert.sendKeys("This is a test");
        fourthAlert.accept();
//        alertMethods.fillAlert("This is a test");

    }
}
