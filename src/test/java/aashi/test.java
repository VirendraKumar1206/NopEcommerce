package aashi;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void report() {
		report = new ExtentReports(System.getProperty("user.dir" + "\\functionality report"));
		test = report.startTest("functionality testing");
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		test.log(LogStatus.PASS, "website is opening");
	}

	@Test(priority = 1)
	public void testHoverAndClick() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement computerLink = driver.findElement(By.linkText("Computers"));
		actions.moveToElement(computerLink).build().perform();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void opennotebooks() throws InterruptedException {
		WebElement notebooksLink = driver.findElement(By.xpath("//a[@href='/software']"));
		notebooksLink.click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testScrollUsingJavaScript() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void oprnproduct() throws InterruptedException {
		driver.findElement(By.linkText("Sound Forge Pro 11 (recurring)")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void scrolldown1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void addtocart() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-button-12")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void shoppingtocart() throws InterruptedException, IOException {
		driver.findElement(By.linkText("shopping cart")).click();
		Thread.sleep(2000);
		TakesScreenshot shots = (TakesScreenshot) driver;
		File file1 = shots.getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\HP\\Music\\ss\\image.png");
		FileUtils.copyFile(file1, file2);
	}

	@Test(priority = 7)
	public void scrolldown2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void checkoutbox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(" //input[@id='Email']")).sendKeys("chakravartiavinash@gmial.com");

		Thread.sleep(3000);
		driver.findElement(By.xpath(" //input[@id='Password']")).sendKeys("avinash@121");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='RememberMe']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void cleanup() {
		driver.close();
	}

//	@AfterClass
//	public void end() {
//		report.endTest(test);
//
//		report.flush();
//	}

}
