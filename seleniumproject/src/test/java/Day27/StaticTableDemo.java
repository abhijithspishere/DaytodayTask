package Day27;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableDemo {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
	//Find total number of rows
		
	int rows =	driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
	
//	System.out.println("the total number of rows : "+rows);
	
	//Find the total number of Columns
	
	int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
	
//	System.out.println("Total number of Columns s : "+cols);
	
	//Read Specific Rows and columns data
	
//	String TableSpecificData = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[2]")).getText();
//	
//	System.out.println("The specific data is : "+TableSpecificData);
	
//	Read all data from the table
	
	/*
	 * for (int r = 2; r <= rows; r++) {
	 * 
	 * for (int c = 1; c <= cols; c++) {
	 * 
	 * String TableAllData =
	 * driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+
	 * "]")).getText();
	 * 
	 * System.out.print(TableAllData+"\t");
	 * 
	 * }
	 * 
	 * System.out.println();
	 * 
	 * }
	 */
	
	//Print book name whose author is Amit
	
	/*System.out.print("Books By Amit are ");
	
	for (int r = 2; r <= rows; r++) {
		
	String author = 	driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
	
	if (author.equals("Amit")) {
		
		String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
		
		System.out.println("\t");
		
		System.out.println(author+"  "+BookName);*/
	
	//Find the sum of all books
	
	int sum = 0;
	
	for( int r=2;r<=rows;r++) {
		
		String Price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		
		sum = sum+Integer.parseInt(Price);
	}
		System.out.println("The total sum is "+sum);
		driver.quit();
	}
}
		
		
	

	


