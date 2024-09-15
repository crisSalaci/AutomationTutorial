package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//h5[text()= 'Alerts, Frame & Windows']")
    public WebElement alertFrameWindowMenu;

    public void clickAlertFrameWindow(){
        elementMethods.clickJSElement(alertFrameWindowMenu);
    }
}
