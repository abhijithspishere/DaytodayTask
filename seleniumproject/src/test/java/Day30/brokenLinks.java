package Day30;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
	List<WebElement>	totalLinks = driver.findElements(By.tagName("a"));
	System.out.println("The total number of links:  "+totalLinks.size());//48 links
	
	int brokenlinks = 0;
	
	for (WebElement totalLinkValue : totalLinks) {
		
		String hrefValue = totalLinkValue.getAttribute("href");
		
		if (hrefValue==null || hrefValue.isEmpty())
		
		{
			
			System.out.println("href value is empty");
			
			continue;
			
		}
		
		//converting hrefvalue which is in string format to URL Format
		URL linkurl = new URL (hrefValue);
		
		//Send the request to the Server
	HttpURLConnection conn= (HttpURLConnection)	linkurl.openConnection(); // here using typecasting since url is changing to http url connection
		
	conn.connect();
	
	if(conn.getResponseCode()>400)
	{
		System.out.println(hrefValue+"           "+"=====>Broken link");
		brokenlinks++;
		
	}
	
	else {
		
		System.out.println(hrefValue+"             "+"===>not a brokenlink");
	}
	 
	System.out.println("Total number of broken links"+brokenlinks);//counting the total number of broken links
		
	}	


	}

}
