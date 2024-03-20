package NopCommerce_Project;

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

public class data_provides {
	WebDriver driver;
	

	@DataProvider(name = "getdata")                                  
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		Extract get = new Extract();
		Object[][] data = get.getdatafromexel();
		return data;
	}

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver(); /*here we are creating an instance of the ChromeDriver class,
		 which implements the WebDriver interface. This allows us to control and automate Google Chrome browser instances using Selenium WebDriver.
		 */
		
		

		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fothers");

		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getdata")  //Specifies that the test method gets its data from the "getdata" data provider.
	public void inputingData(String First, String Last, String Email, String Company, String Password,
			String ConfirmPassword) throws InterruptedException {
		WebElement fname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		WebElement lname = driver.findElement(By.xpath("//input[@id='LastName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement cpass = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));

		fname.sendKeys(First);
		Thread.sleep(3000);
		lname.sendKeys(Last);
		Thread.sleep(3000);
		email.sendKeys(Email);
		Thread.sleep(3000);
		company.sendKeys(Company);
		Thread.sleep(3000);
		pass.sendKeys(Password);
		Thread.sleep(3000);
		cpass.sendKeys(ConfirmPassword);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
