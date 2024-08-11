package Day22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

/*get(url)
getTitle()
getCurrentURL()
getPageSource()
getWindowHandle()
getwindowHandles()
*/

public class GetMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://orangehrm.com/");
		
		driver.manage().window().maximize();
		
		
		//implicit wait method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//get title//
		 System.out.println("Title of the page "+driver.getTitle());
		 
		 System.out.println("The current Url "+driver.getCurrentUrl());
		
		}

}
