package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "sampleHeading")
    public WebElement sampleTextElement;
    @FindBy(xpath = "sampleHeading")
    public WebElement secondSampleTextElement;

    public void dealFirstIFrame(){
        frameMethods.switchToSpecificIFrame("frame1");
        System.out.println(sampleTextElement.getText());
        frameMethods.switchToParentIFrame();
    }

    public void dealSecondIFrame(){
        frameMethods.switchToSpecificIFrame("frame2");
        System.out.println(secondSampleTextElement.getText());
    }
}
