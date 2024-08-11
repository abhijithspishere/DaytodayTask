package Day26;

import java.time.Duration;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HandlingWindowsAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/*
		 * try { Thread.sleep(3000); } catch (Exception e) { e.printStackTrace(); }
		 */
		List <WebElement>searchList= driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		
		System.out.println("Total number of links : "+searchList.size());
		
		System.out.println("printing & clicking links................");
		
		for (WebElement list : searchList) {
			
			System.out.println(list.getText());
			
			list.click();
			
		}
		
		System.out.println("Titles of the pages are :");
		
	Set<String>WindowID = driver.getWindowHandles();
	
	for (String Wid : WindowID) {
		
		String title = driver.switchTo().window(Wid).getTitle();		
		
		System.out.println(title);
	}
		
		driver.quit();
		
	

	}

}
