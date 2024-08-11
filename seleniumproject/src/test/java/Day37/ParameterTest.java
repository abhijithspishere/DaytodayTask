package Day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"Browser","URL"})
	void setup(String br, String appUrl)
	{
		
		if(br.equals("Chrome")) 
		 {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if (br.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else
		
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(appUrl);
	    driver.manage().window().maximize();
	    
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    
		
		
	}
	
	@Test(priority = 1)
	void testLogo()
	{
		try {
			
			
			WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
			boolean Status = logo.isDisplayed();
//			boolean Status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(Status,true);
		} 
		
		catch (Exception e) 
		{
			Assert.fail("Exception Occured: " +e.getMessage());
		}
	}
	
	@Test(priority=2)
	void testHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Titles are not Matched");
	}
	
	@AfterClass
	void closeApp()
	
	{
		driver.quit();
	}

}
