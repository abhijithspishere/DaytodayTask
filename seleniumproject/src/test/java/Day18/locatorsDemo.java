package Day18;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class locatorsDemo {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//open app
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize(); //maximize window
		
		//search box finding and pass tshirt
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		
		//finding the button by name and click
		driver.findElement(By.name("submit_search")).click();
		
		//finding by linktext
//		driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		
		//finding by partial link text
		//always try to use linktext rather than partial link text
		driver.findElement(By.partialLinkText("Chiffon")).click(); 	
		
		
		
		
		
		
		
		
		
	}

}
