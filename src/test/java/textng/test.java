package textng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	driver = new ChromeDriver();
   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();
    driver.get("https://demo.nopcommerce.com/");
    Thread.sleep(3000);
}
@Test(priority = 1)
public void testHoverAndClick() throws InterruptedException {
    Actions actions = new Actions(driver);
    WebElement Electronics  = driver.findElement(By.linkText("Electronics"));
    actions.moveToElement(Electronics).build().perform();
	  Thread.sleep(3000);
}
    @Test(priority = 2)
    public void Others () throws InterruptedException {
    WebElement Others  = driver.findElement(By.linkText("Others "));
    Others .click();
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
	driver.findElement(By.linkText("Universal 7-8 Inch Tablet Cover")).click();
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
	driver.findElement(By.id("Add to cart")).click();
	  Thread.sleep(3000);
}
@Test(priority = 6)
public void shoppingtocart() throws InterruptedException, IOException {
	driver.findElement(By.linkText("Shopping cart")).click();
	  Thread.sleep(2000);
	  TakesScreenshot shots = (TakesScreenshot)driver;
		 File file1 = shots.getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\Namita Pandey\\Pictures\\take screenshot\\image.png");
		FileUtils.copyFile(file1, file2);
}
	 
@Test(priority = 7)
public void scrolldown2() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	  Thread.sleep(3000);
	  
}	  
@Test
public void checkbox() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	  Thread.sleep(2000);
	  
}
@Test(priority = 8)
public void checkoutbox() throws InterruptedException {
	driver.findElement(By.id("checkout")).click();
	  Thread.sleep(3000);
}
@AfterTest
public void cleanup() {
    if (driver != null) {
        driver.quit();
    }
}
}
