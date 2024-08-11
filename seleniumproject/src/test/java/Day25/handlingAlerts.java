package Day25;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingAlerts {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Can't use this implicit wait when alert window is taking sometime
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		
		
		
		
//		Alert alertWindow = driver.switchTo().alert(); 
		//This is based on fetching alert window without explicit wait
		
		//fetching alert using explicitwait
		Alert alertWindow = mywait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(	alertWindow.getText());
		
		//alertWindow.accept();//this will close alert using accept,ok,submit button
		
		alertWindow.dismiss(); //this will cancel the alert window 
	}

} 
