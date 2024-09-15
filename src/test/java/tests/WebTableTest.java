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

        ElementMethods elementMethods = new ElementMethods(driver);
        //daca vrei sa identifici un element dupa un text => XPath (2 tipuri: absolut(nu se foloseste. de recunoscut: incepe cu un /) si relativ(e cu doua //) => denumit locator sau selector)
        WebElement elementsMenu=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementMethods.clickJSElement(elementsMenu);

        WebElement webTableSubMenu=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementMethods.clickJSElement(webTableSubMenu);

        //validam dimensiunea initiala a tabelului
        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(),3,"Default size for table is not 3.");

        //definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickJSElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Cristina";
        elementMethods.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Salaci";
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "cristina_salaci@test.com";
        elementMethods.fillElement(userEmailElement,userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "34";
        elementMethods.fillElement(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        elementMethods.fillElement(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "testing";
        elementMethods.fillElement(departmentElement,departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJSElement(submitElement);

        //validam noua dimensiune a tabelului
        List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),4,"Default size for table is not 4.");

        // validam valorile pe care le-am introdus
        String rowContent = newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row does not contain first name value.");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row does not contain last name value.");
        Assert.assertTrue(rowContent.contains(userEmailValue),"The last row does not contain email value.");
        Assert.assertTrue(rowContent.contains(ageValue),"The last row does not contain age value.");
        Assert.assertTrue(rowContent.contains(salaryValue),"The last row does not contain salary value.");
        Assert.assertTrue(rowContent.contains(departmentValue),"The last row does not contain department value.");

        //edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementMethods.clickJSElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Cris";
        elementMethods.clearEditElement(editFirstNameElement,editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Sal";
        elementMethods.clearEditElement(editLastNameElement,editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "popescu@gmail.com";
        elementMethods.clearEditElement(editEmailElement,editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "24";
        elementMethods.clearEditElement(editAgeElement,editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "30000";
        elementMethods.clearEditElement(editSalaryElement,editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        elementMethods.clearEditElement(editDepartmentElement,editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        elementMethods.clickJSElement(editSubmitElement);

        //validam valorile modificate din tabel
        rowContent = newTableContentList.get(3).getText();
        Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row does not contain first name value.");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row does not contain last name value.");
        Assert.assertTrue(rowContent.contains(editEmailValue),"The last row does not contain email value.");
        Assert.assertTrue(rowContent.contains(editAgeValue),"The last row does not contain age value.");
        Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row does not contain salary value.");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row does not contain department value.");

        //delete functionality
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementMethods.clickJSElement(deleteElement);

        newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),3,"Default size for table is not 3.");

       // driver.quit();
    }
}
