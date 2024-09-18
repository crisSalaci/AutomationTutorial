package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public AlertFrameWindowPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsElement;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElement;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsElement);
    }
    public void clickBrowserWindowSubMenu(){
        elementMethods.clickJSElement(browserWindowSubMenu);
    }
    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesElement);
    }
}



