package Day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Select Specific checkbox
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//Total number of checkboxes
		//here list Webelement is based on index number 01 so for loop should starts with i=0;
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		System.out.println("Total number of checkboxes :"+checkboxes.size());
		
		//regular method
		/*
		 * for (int i = 0; i < checkboxes.size(); i++) 
		 * { 
		 *    checkboxes.get(i).click(); 
		 * }
		 */
		
		//advanced for loop
		/*for(WebElement chkbox : checkboxes)
		 *  {
			chkbox.click();
		}*/
		
		//Select last 2 checkboxes
		//there are 7 checkboxes starting from 0 so(starting index = total checkboxes - needable checkbox)=> 
//		7-2=5 should start from 5
		/*
		 * for (int i = 5; i < checkboxes.size(); i++) 
		 * { 
		 * checkboxes.get(i).click(); 
		 * }
		 */
		
		//Select first 2 checkboxes
		
		/*
		 * for (int i = 0; i < 2; i++)
		 *  {
		 *  checkboxes.get(i).click();
		 *   }
		 *   
		 */
			//Select first 2 checkboxes using if condition with for loop
			/*
			 * for (int i = 0; i < checkboxes.size(); i++) 
			 * { 
			 * if (i<2) 
			 * {
			 * checkboxes.get(i).click();
			 *  }
			 * 
			 * }
			 */
			
		//Clear or uncheck all  checkboxes
		/*
		 * for (int i = 0; i < checkboxes.size(); i++) 
		 * 
		 * { 
		 *  
		 *  checkboxes.get(i).click();
		 *   }
		 * Thread.sleep(4000);
		 * 
		 * for (int i = 0; i < checkboxes.size(); i++) { checkboxes.get(i).click(); }
		 */
		 
		
		 
		 for (int i = 0; i < 3; i++) //condition for selecting first 3 checkboxes
		 { 
		   checkboxes.get(i).click(); 
		 }
		 
		 //
	 Thread.sleep(4000);
	 //clear or uncheck only three elements using normal for loop
		/*
		 * for (int i = 0; i < checkboxes.size(); i++) { if
		 * (checkboxes.get(i).isSelected()) //condition for unselect only if is selected
		 * { checkboxes.get(i).click(); }
		 * 
		 * }
		 */
	 //clear or uncheck only three elements using enhanced for loop
	 for (WebElement chkbox : checkboxes) {
		if (chkbox.isSelected()) {
			chkbox.click(); 
		}
	}
		
		
		

	}

}
