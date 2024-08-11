package Day26;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//DEMO WEBSITE PROGRAM
import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingFramesUsingWebElement {

	public static void main(String[] args) { 
		
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebsitename");
		
		//Used when the frame have No Name,Id,and Index
		
		//Here I stores the whole Frame as a webelement to FrameElement and uses usual StichTo statement on FrameElement
		//not the frame name, frame ID
		
		WebElement FrameElement = driver.findElement(By.xpath("//iframe[@title='abhijit']"));
		driver.switchTo().frame(FrameElement); 
		
		//Finding the element on the frame
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Abhijith");
		
		

	}

}
