package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabWindowPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public TabMethods tabMethods;

    public TabWindowPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabElement;
    @FindBy(id = "windowButton")
    public WebElement newWindowElement;

    public void dealTabProcess(){
        elementMethods.clickJSElement(newTabElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);
    }

    public void dealWindowProcess(){
        elementMethods.clickJSElement(newWindowElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        driver.quit();
    }
}
