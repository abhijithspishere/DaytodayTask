package Day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownwithoutSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='country-list']")).click();
		
		List<WebElement>options = driver.findElements(By.xpath("//*[@id='country-list']/option"));
		System.out.println("Total no of options :"+options.size());
		
		for(WebElement option:options) {
			String text = option.getText();
//			System.out.println(text);
			
			if (text.equals("India") ) {
				option.click();
				
			}
		}
		
		
	    try {
            Thread.sleep(3000); // Wait for suggestions to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	    
	    
		driver.findElement(By.xpath("//*[@id='state-list'and@class='demoInputBox']")).click();
		

		
		List<WebElement>stateOptions=driver.findElements(By.xpath("//*[@id='state-list']/option"));
		System.out.println("Total no of Stateoptions :"+stateOptions.size());
		
		for (WebElement state : stateOptions) {
			String stateText = state.getText();
			System.out.println(stateText);
	
		
			if (stateText.equals("Delhi")) {
				state.click();
				break;
				
			}
			
		}
		
		
		
		
		

	}

}
