package textng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class testng2 {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement computer = driver.findElement(By.xpath("//a[@href='/computers']"));
		Actions act = new Actions(driver);
		act.moveToElement(computer).build().perform();
		
		driver.findElement(By.xpath("//a[@href='/software']")).click();
		
		List<WebElement> drops = driver.findElements(By.xpath("//select[@id='products-orderby']"));
		 for(WebElement drop : drops) {
			 drop.click();
		 }
		
		
		 driver.findElement(By.xpath("//a[@href='/windows-8-pro']")).click();
		
		
		      Thread.sleep(8000);
		      driver.findElement(By.xpath("//button[@id='add-to-cart-button-11']")).click();
		     
		     
		      Thread.sleep(4000);
		     
		      driver.findElement(By.xpath("//a[@href='/cart']")).click();
		     
		     
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
}
