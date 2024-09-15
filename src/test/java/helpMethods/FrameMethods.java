package helpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver) {

        this.driver = driver;
    }

    public void switchToSpecificIFrame(String value){
        driver.switchTo().frame(value);
    }

    public void switchToParentIFrame(){
        driver.switchTo().parentFrame();
    }
    public void switchToSpecificIFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }
}
