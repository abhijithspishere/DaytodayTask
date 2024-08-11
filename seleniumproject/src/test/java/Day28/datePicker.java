package Day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datePicker {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");

		driver.manage().window().maximize();

		WebElement Frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(Frame);

		// Since there are one frame we can use below code too

		// driver.switchTo().frame(0);

		// Approach Number One : This is used almost all time
		/*
		 * WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
		 * 
		 * datePicker.sendKeys("04/12/2025");
		 * 
		 */
		
		//Approach Two
		String year = "2028";
		String month = "March";
		String date = "23";
		
		WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
		  
		  datePicker.click();
		  
		  while (true) {
			  
			  String Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			  String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			  
			  if (Month.equals(month) && Year.equals(year)) {
				 break; 
				  
				
			} 
			  
			  WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
			  next.click();
		   }
		  
		List<WebElement> allDates =  driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for (WebElement eachDate : allDates) {
			if (eachDate.getText().equals(date)) {
				
				eachDate.click();
				break;
				
			}
		}
	}

}
