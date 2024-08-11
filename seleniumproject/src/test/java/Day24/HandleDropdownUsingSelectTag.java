package Day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownUsingSelectTag {



		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver(); 
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
			driver.manage().window().maximize();
			
			WebElement dropConElement=driver.findElement(By.xpath("//select[@id='country-list']")); 
			Select dropCountry = new Select(dropConElement);
			
			//Select using actual Text available on the DOM
//			dropCountry.selectByVisibleText("Brazil");
			
			//We can Select using Option Value or attribute of the element
//			dropCountry.selectByValue("2");
			
			
			//Also by using IndexMethod Its starts from 0
//			dropCountry.selectByIndex(3);
			//no need of double quotation for 3
			
			List<WebElement>options = dropCountry.getOptions();		
			System.out.println("Total no of options available : "+options.size());
			
			//Print options on console window
			System.out.println("The available options are :");
			/*
			 * for (int i = 0; i < options.size(); i++) {
			 * 
			 * System.out.println(options.get(i).getText());
			 * 
			 * 
			 * }
			 */
			
			//using Enhanced for loop
			for (WebElement opt : options) {
				System.out.println(opt.getText());
				
			}

		}

	}


