package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

import java.util.List;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void metoda(){
        //deschidem un browser
        driver = new EdgeDriver();
        //accesam un URL
        driver.get("https://demoqa.com");
        //facem browserul maximized
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.clickWebTable();

        String firstNameValue = "Cristina";
        String lastNameValue = "Salaci";
        String userEmailValue = "cristina_salaci@test.com";
        String ageValue = "34";
        String salaryValue = "1000";
        String departmentValue = "testing";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.createProcess(firstNameValue, lastNameValue, userEmailValue, ageValue, salaryValue, departmentValue, 3);

        String editFirstNameValue = "Cris";
        String editLastNameValue = "Sal";
        String editEmailValue = "popescu@gmail.com";
        String editAgeValue = "24";
        String editSalaryValue = "30000";
        String editDepartmentValue = "HR";

        webTablePage.editProcess(editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue, editSalaryValue, editDepartmentValue, 3);

        webTablePage.deleteProcess(3);
        driver.quit();
    }
}
