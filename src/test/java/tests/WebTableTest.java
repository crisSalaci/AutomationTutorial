package tests;

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
        //daca vrei sa identifici un element dupa un text => XPath (2 tipuri: absolut(nu se foloseste. de recunoscut: incepe cu un /) si relativ(e cu doua //) => denumit locator sau selector)

        WebElement elementsMenu=driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", elementsMenu);

        WebElement webTableSubMenu=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        js.executeScript("arguments[0].click()", webTableSubMenu);


        //validam dimensiunea initiala a tabelului
        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
//        System.out.println("Dimensiunea tabelului este "+tableContentList.size());
        Assert.assertEquals(tableContentList.size(),3,"Default size for table is not 3.");


        //definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Cristina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Salaci";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "cristina_salaci@test.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "34";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "testing";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()", submitElement);

        //validam noua dimensiune a tabelului
        List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),4,"Default size for table is not 4.");

        // validam valorile pe care le-am introdus
        String rowContent = newTableContentList.get(3).getText();
        //System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue),"The last row does not contain first name value.");
        Assert.assertTrue(rowContent.contains(lastNameValue),"The last row does not contain last name value.");
        Assert.assertTrue(rowContent.contains(userEmailValue),"The last row does not contain email value.");
        Assert.assertTrue(rowContent.contains(ageValue),"The last row does not contain age value.");
        Assert.assertTrue(rowContent.contains(salaryValue),"The last row does not contain salary value.");
        Assert.assertTrue(rowContent.contains(departmentValue),"The last row does not contain department value.");

        //edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        //variabila js e definita mai sus
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Cris";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Sal";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        String editEmailValue = "popescu@gmail.com";
        editEmailElement.clear();
        editEmailElement.sendKeys(editEmailValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        String editAgeValue = "24";
        editAgeElement.clear();
        editAgeElement.sendKeys(editAgeValue);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "30000";
        editSalaryElement.clear();
        editSalaryElement.sendKeys(editSalaryValue);

        WebElement editDepartmentElement = driver.findElement(By.id("department"));
        String editDepartmentValue = "HR";
        editDepartmentElement.clear();
        editDepartmentElement.sendKeys(editDepartmentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        //editSubmitElement.click();
        js.executeScript("arguments[0].click()", editSubmitElement);

        //validam valorile modificate din tabel
        rowContent = newTableContentList.get(3).getText();
        //System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row does not contain first name value.");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row does not contain last name value.");
        Assert.assertTrue(rowContent.contains(editEmailValue),"The last row does not contain email value.");
        Assert.assertTrue(rowContent.contains(editAgeValue),"The last row does not contain age value.");
        Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row does not contain salary value.");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row does not contain department value.");
        //delete functionality
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        js.executeScript("arguments[0].click()", deleteElement);

        newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class ='rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newTableContentList.size(),3,"Default size for table is not 3.");

       // driver.quit();
    }
}
