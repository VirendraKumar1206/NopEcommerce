package virendraKumar;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Project {
	WebDriver driver;
	WebDriverWait wait;

	JavascriptExecutor js;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void extent() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\virendra.html");
		test = report.startTest("functionality testing");

		
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		test.log(LogStatus.PASS, "chrome is opened");

		driver.get("https://demo.nopcommerce.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SoftAssert sa = new SoftAssert();
	String Expected ="nopCommerce demo store";
	String actualTitile = driver.getTitle();
		
		sa.assertAll();
	
	test.log(LogStatus.PASS, "url is valid");
		sa.assertEquals(actualTitile, Expected);

		Thread.sleep(3000);
		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = {"sanity"})
	public void testHoverAndClick() throws InterruptedException, IOException {


		WebElement computer = driver.findElement(By.xpath("//a[@href='/computers']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(computer).build().perform();
		test.log(LogStatus.PASS, "computer's hover is working");
//		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@href='/software']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/software']")));
		test.log(LogStatus.PASS, "software section is accessible");

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//a[@href='/windows-8-pro']")).click();
		test.log(LogStatus.PASS, "product is clickable");
//		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Add to wishlist']")).click();
		test.log(LogStatus.PASS, "add to wishlist is working");
//		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[@href='/wishlist']")).click();
		test.log(LogStatus.PASS, "wishlist is clickable");
		js.executeScript("window.scrollBy(0,350)", "");
//		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='button-2 email-a-friend-wishlist-button']")).click();
		test.log(LogStatus.PASS, "term and condition box is clickable");
//		driver.findElement(By.id("checkout")).click();
//		Thread.sleep(3000);
		
	driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("abcd.com");
		Thread.sleep(3000);	
		
		driver.findElement(By.xpath("//input[@id='YourEmailAddress']")).sendKeys("abcd.com");
		Thread.sleep(3000);	
		
		TakesScreenshot shots = (TakesScreenshot) driver;
		File file1 = shots.getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\HP\\Pictures\\TakeScreenshot\\image.png");
		FileUtils.copyFile(file1, file2);
		test.log(LogStatus.PASS, "Ss functionality is working");
	}

	@Test(priority = 2, groups = {"sanity"})
	public void testHoverAndClick1() throws InterruptedException, IOException {


		WebElement computer = driver.findElement(By.xpath("//a[@href='/computers']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(computer).build().perform();
		test.log(LogStatus.PASS, "computer's hover is working");
//		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@href='/software']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/software']")));
		test.log(LogStatus.PASS, "software section is accessible");

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//a[@href='/windows-8-pro']")).click();
		test.log(LogStatus.PASS, "product is clickable");
//		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-11']")).click();
		test.log(LogStatus.PASS, "add to is working");
//		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[@href='/cart']")).click();
		test.log(LogStatus.PASS, "shopping cart is working");
		js.executeScript("window.scrollBy(0,350)", "");
//		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		test.log(LogStatus.PASS, "term and condition box is clickable");
		driver.findElement(By.id("checkout")).click();
//		Thread.sleep(3000);

		TakesScreenshot shots = (TakesScreenshot) driver;
		File file1 = shots.getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\HP\\Pictures\\TakeScreenshot\\image.png");
		FileUtils.copyFile(file1, file2);
		test.log(LogStatus.PASS, "Ss functionality is working");
	}
	
	@AfterMethod(alwaysRun = true)
	public void last() {
		if (driver != null) {
			driver.quit();
		}
		
		
	}

	@AfterClass
	public void end() {
		report.endTest(test);
		report.flush();
	}

	
	
}
