package Day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderTestNGwithData {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test(dataProvider="dp")
	void testlogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		String ExpTitle = "nopCommerce demo store";
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(ExpTitle, actTitle);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	
	@DataProvider(name ="dp")
	String [] [] loginData()
	{
		String data[][] = {
				
				{"abc@gmail.com","test123"},
				{"xyz@gmail.com","test456"}
				
		};
		
		return data;
	}

}
