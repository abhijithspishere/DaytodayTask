package Day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPagePOM2 {

    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public LoginPagePOM2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
        PageFactory.initElements(driver, this);
    }


    //WebElements Without Find Elements (WebElements Locators + Identification)
    
    @FindBy(xpath = "//img[@alt='company-branding']") 
    WebElement img_logo;
    
    @FindBy(name ="username" )
    WebElement txt_username;
    
    @FindBy(name = "password")
    WebElement txt_password;
    
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btn_submit;
    
    //If we wants to store all links on Selenium we use FindElements by but here we use
	/*
	 * @FindBy(tagName="a") 
	 * List<WebElement> links;
	 */
    
	  public void setUsername(String username) 
	  {
		  txt_username.sendKeys(username); 
		  }
	  
	  public void setPassword(String password)
	  {
		  txt_password.sendKeys(password);
		  }
	  
	  public void clickSubmit()
	  { 
		  btn_submit.click(); 
	  }
	  
	  public boolean checkLogoPresence() 
	  
	  { 
		  boolean status =img_logo.isDisplayed(); 
		  return status;
  
	  }
	 
    
}
