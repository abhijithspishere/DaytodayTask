package Day25;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingAlertwithUsernameandPassword {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the URL that requires basic authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		String text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
		
	
		
		if (text.contains("Congratulations")) {
			
			System.out.println("Test passed");
			
			
		} else {
			
			System.out.println("Test failed");

		}
		
		
	}

}
