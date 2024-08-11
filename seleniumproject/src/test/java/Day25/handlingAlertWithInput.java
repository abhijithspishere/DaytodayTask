package Day25;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingAlertWithInput {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click(); 
		
		Alert alertWindow = driver.switchTo().alert();
		
		alertWindow.sendKeys("Welcome");
		
		//alertWindow.accept();
		
		alertWindow.dismiss();
		
		//Validation
		
		String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		String expectText = "You entered: Welcome";
		
		if (actualText.equals(expectText)) {
			
			System.out.println("Test passed");
			
			
		} else {
			
			System.out.println("Test failed");

		}
		
		
	}

}
