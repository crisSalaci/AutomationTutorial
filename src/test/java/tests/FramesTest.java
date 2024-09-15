package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class FramesTest {
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
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickJSElement(framesElement);

        //ne mutam pe un iFrame
        frameMethods.switchToSpecificIFrame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());

        frameMethods.switchToParentIFrame();

        frameMethods.switchToSpecificIFrame("frame2");

        WebElement secondSampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondSampleTextElement.getText());

        //TEMA - Nested frames
    }
}
