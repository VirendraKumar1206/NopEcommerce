package aashi;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Dataprovider {
	
	    WebDriver driver;
	    
//	    This is the data provider for the coded
	    
	    @DataProvider(name = "getdata")
	    
	    public Object[][] getdata() throws EncryptedDocumentException, IOException {
	    	Extract get = new Extract();
	        Object[][] data = get.getdatafromexel();
	        return data;
	    }
	    
//	    This is the setup for system
	    
	    @BeforeMethod(alwaysRun = true)
	    public void first() throws InterruptedException {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	        driver.manage().window().maximize();
	    }
//	    This the test case to check register details
	    
	    @Test(dataProvider = "getdata")
	    public void test(String firstName, String lastName, String email, String companyName, String password, String confirmPassword) throws InterruptedException {
	        WebElement fname = driver.findElement(By.id("FirstName"));
	      
	        WebElement lname = driver.findElement(By.id("LastName"));
	      
	        WebElement email1 = driver.findElement(By.id("Email"));
	       
	        WebElement company = driver.findElement(By.id("Company"));
	        
	        WebElement password1 = driver.findElement(By.id("Password"));
	        
	        WebElement confirmPassword1 = driver.findElement(By.id("ConfirmPassword"));
	        Thread.sleep(2000);
	        fname.sendKeys(firstName);
	        Thread.sleep(2000);
	        lname.sendKeys(lastName);
	        Thread.sleep(2000);
	        email1.sendKeys(email);
	        Thread.sleep(2000);
	        company.sendKeys(companyName);
	        Thread.sleep(2000);
	        password1.sendKeys(password);
	        Thread.sleep(2000);
	        confirmPassword1.sendKeys(confirmPassword);
	        Thread.sleep(2000);
        driver.findElement(By.id("register-button")).click();
	        Thread.sleep(2000);
	    }
	    
	    @AfterMethod
	    
	    public void last() {
	        driver.close();
	    }
	}

