package Day25;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class autoSuggestDropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("selenium");
		
        
        
        try {
            Thread.sleep(3000); // Wait for suggestions to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
		
//		List<WebElement>list = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
        List<WebElement>list = driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
		
		System.out.println("Number of Suggestions:"+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			
			if (text.equals("selenium webdriver") ) {
				list.get(i).click();
				break;
				
			}
		}
		

	}

}
