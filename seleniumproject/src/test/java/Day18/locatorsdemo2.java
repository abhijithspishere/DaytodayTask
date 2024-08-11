package Day18;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class locatorsdemo2 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//open app
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize(); //maximize window
		
		//List no of sliders in HomePage
		List<WebElement> sliders = driver.findElements(By.className("homeslider-container"));
		System.out.println("Total no of sliders in HomePage :"+sliders.size());
		
		//List no of Images 
		List<WebElement>images=driver.findElements(By.tagName("img"));
		System.out.println("Total o of Images :"+images.size());
		
		//list all links
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("Total o of Links :"+links.size());
		
		driver.quit();
		
		
		
	}

}
