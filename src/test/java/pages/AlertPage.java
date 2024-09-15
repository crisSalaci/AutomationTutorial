package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertMethods alertMethods;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        alertMethods = new AlertMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "alertButton")
    public WebElement okAlert;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButtonElement;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlert;
    @FindBy(id = "promtButton")
    public  WebElement alertPrompt;

    public void dealAlertProcess(String text){
        elementMethods.clickJSElement(okAlert);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(confirmAlert);
        alertMethods.dismissAlert();
        elementMethods.clickJSElement(alertPrompt);
        Alert fourthAlert=driver.switchTo().alert();
        System.out.println(fourthAlert.getText());
        fourthAlert.sendKeys("This is a test");
        fourthAlert.accept();
    }

}
