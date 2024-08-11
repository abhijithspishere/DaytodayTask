package Day33;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.formula.functions.Rate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		driver.manage().window().maximize();
		
		//First should deals with Excel Sheets
		
		String file = System.getProperty("user.dir")+"//testdata//caldata.xlsx "; //Location of the Excel file stored on file
		
		int Rows = ExcelUtils.getRowCount(file,"Sheet1");
		
		//Read Data From Excel.
		
		for(int i =1 ; i<=Rows;i++)/// We started with i = 1 because we dont need header.
		{
			String Principal = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			String RateOfInterest = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			String Period1= ExcelUtils.getCellData(file, "Sheet1", i, 2);
			String Period2= ExcelUtils.getCellData(file, "Sheet1", i, 3);
			String Freq= ExcelUtils.getCellData(file, "Sheet1", i, 4);
			String ExpMaturity = ExcelUtils.getCellData(file, "Sheet1", i, 5);
			
			//Pass Data to the application
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(Principal);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period1);
			
			//Period 2 is a Dropdown So have to use Select
			//the dropdown values from Excel table must be similar to actual value from the webapp
			Select PeriodDrop = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			PeriodDrop.selectByVisibleText(Period2);
			
			//Frequency also Dropdown
			
			Select FrequencyDrop = new Select (driver.findElement(By.xpath("//select[@id='frequency']")));
			FrequencyDrop.selectByVisibleText(Freq);
			
			
		   //Clicking on the calculate Button
		   WebElement calculate = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();",calculate);
		   

		   
		   //Clicking on the calculate Button
		   
		   //Validation and Update the Results in result column in Excel
		   
		   String ActMaturity = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
		   
		   //Here We need to validate the Actual maturity value and Expected Maturity value 
		   //But both are in String now Inorder to compare We have to convert to Number
		   
		   if(Double.parseDouble(ExpMaturity)==Double.parseDouble(ActMaturity))
		   {
			   System.out.println("Test Passed");
			   ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
			   ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
		   }
		   
		   else
		   {
			   System.out.println("Test Failed");
			   ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
			   ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
		   }
		   
		   System.out.println("tessts"); 
		   Thread.sleep(3000);
		 WebElement clear_btn =   driver.findElement(By.xpath("//img[@class='PL5']"));
		 JavascriptExecutor exec = (JavascriptExecutor)driver;
		 exec.executeScript("arguments[0].click();",clear_btn);
			
		}

	}

}
