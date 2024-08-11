package Day17;


import org.openqa.selenium.By;

/*Test case
--------
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : OrangeHRM
7) close browser*/


import org.openqa.selenium.WebDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest { 
	
public static void main(String[] args) throws InterruptedException { 
	
//	WebDriverManager.chromedriver().setup(); ---> This command is not used after 4. version
	
	
//	 ChromeDriver driver = new ChromeDriver();
	WebDriver driver = new ChromeDriver();
	
	//open url on the browser
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	// used to maximize the window 
	driver.manage().window().maximize();
	//used when browser doesn't load properly
	Thread.sleep(5000 );
	
	//used to identify username and provides username
	driver.findElement(By.name("username")).sendKeys("Admin");
	
	//identify password and provides password
	driver.findElement(By.name("password")).sendKeys("admin123");
	
	//used to identify the submit button using xpath and click is used for make a click on login button
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	
	
	//Verify the title of dashboard page  title
	/*
	 * String actTitle = driver.getTitle(); String expTitle = "OrangeHRM";
	 * 
	 * if(actTitle.equals(expTitle)) { System.out.println("Test Passed"); }
	 * 
	 * else { System.out.println("Test failed"); }
	 */
	
	
	//verification of dashboard
	driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
	
	//close the browser
//	driver.close();
//	driver.quit();
	
	
	
}
}
