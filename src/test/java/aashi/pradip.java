package aashi;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class pradip {
	
	    WebDriver driver;
//	    ExtentReports report;
//	    ExtentTest test;
//	    @BeforeMethod(alwaysRun = true)
//	    public void reportSetUp() {
//	        report = new ExtentReports(System.getProperty("user.dir") + "\\ProjectReport.html"); // this is the name of my // report file
//	        test = report.startTest("Setup is done for test");
//	    }
	    @BeforeTest
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demo.nopcommerce.com/");
//	        test.log(LogStatus.PASS, "Browser opened successfully");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    @Test
	    public void First() throws InterruptedException {
	    	
	        WebElement computer = driver.findElement(By.xpath("//a[@href='/computers']"));
	        Actions Hover = new Actions(driver);
	        Hover.moveToElement(computer).build().perform();
//	        test.log(LogStatus.PASS, "Mouse Hover");
	        WebElement DesktopSubMenu = driver.findElement(By.xpath("//a[@href='/desktops']"));
	        DesktopSubMenu.click();
	        Thread.sleep(2000);
//	        test.log(LogStatus.PASS, "Desktop click");
	        WebElement ImageDetails = driver.findElement(By.xpath("//img[@alt='Picture of Build your own computer'][1]"));
	        ImageDetails.click();
//	        test.log(LogStatus.PASS, "show detail");
	    	
	      	
//	      Writing drop down scripts
	 	   WebElement selDropDown = driver.findElement(By.id("product_attribute_1"));
	      Select selectProcessor =new Select(selDropDown);
	      selectProcessor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
//	      test.log(LogStatus.PASS, "Selected");
	      WebElement DropDown2 = driver.findElement(By.id("product_attribute_2"))  ;
	      Select select2Drop = new Select(DropDown2);
	      select2Drop.selectByVisibleText("4GB [+$20.00]");
//	      test.log(LogStatus.PASS, "Selected ram");
	      Thread.sleep(3000);
//	     Ram selection
	      WebElement RadioBtn = driver.findElement(By.id("product_attribute_3_7"));
	      RadioBtn.click();
	      Thread.sleep(3000);
//	      test.log(LogStatus.PASS, "Radio button click");
//	      Os selection
	      WebElement Os = driver.findElement(By.id("product_attribute_3_7"));
	      Os.click();
	      Thread.sleep(2000);
//	      test.log(LogStatus.PASS, "Os selected");
//	      Software check boxes
	      List<WebElement> software = driver.findElements(By.xpath("//input[@type='checkbox']"));
	      for (WebElement clickSoftware : software) {
	    	  clickSoftware.click();
	    	  Thread.sleep(2000);
	    	 
//	    	  test.log(LogStatus.PASS, "click check box");
		 }
//	      Add to cart button
	       WebElement cart = driver.findElement(By.id("add-to-cart-button-1"));
	      cart.click();
//	      test.log(LogStatus.PASS, "Clicked cart page");
	      Thread.sleep(4000);
	    }
	    
	    @Test
	    public void shoppingtocart() throws InterruptedException, IOException {
	    	driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	    	
	    }
	    	 
	    @Test
	    public void scrolldown2() throws InterruptedException {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,350)", "");
	    	  Thread.sleep(3000);
	    }

	    @Test
	    public void checkbox() {
	    	
	    	driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	    	
	    	
	    }





	    @Test
	    public void checkoutbox() throws InterruptedException, IOException {
	    	driver.findElement(By.id("checkout")).click();
	    	  Thread.sleep(3000);
	    	  
	    	  TakesScreenshot shots = (TakesScreenshot)driver;
	    	  File file1 = shots.getScreenshotAs(OutputType.FILE);
	    	  File file2 = new File("C:\\Users\\HP\\Pictures\\TakeScreenshot\\image.png");
	    	  FileUtils.copyFile(file1, file2);
	    }
	    
	    @AfterTest
	    public void TearDown() throws InterruptedException {
	          driver.close();
//	          report.endTest(test);
//	          report.flush();
	    }
	}

