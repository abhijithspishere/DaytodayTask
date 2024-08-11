package Day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPagePOM {

    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
    }

    // Locators
    By img_logo_loc = By.xpath("//img[@alt='company-branding']");
    By txt_username_loc = By.name("username");
    By txt_password_loc = By.name("password");
    By btn_submit_loc = By.xpath("//button[normalize-space()='Login']");
    
	//This is from Online Class But It Shows Error
	  public void setUsername(String username) {
	  driver.findElement(txt_username_loc).sendKeys(username); }
	  
	  public void setPassword(String password) {
	  driver.findElement(txt_password_loc).sendKeys(password); }
	  
	  public void clickSubmit() { driver.findElement(btn_submit_loc).click(); }
	  
	  public boolean checkLogoPresence() { boolean status =
	  driver.findElement(img_logo_loc).isDisplayed(); return status; }
	 
    // Action Methods
    
    //This is from Chat GPT But it is working fine
	/*
	 * public void setUsername(String username) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username_loc)).
	 * sendKeys(username); }
	 * 
	 * public void setPassword(String password) {
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password_loc)).
	 * sendKeys(password); }
	 * 
	 * public void clickSubmit() {
	 * wait.until(ExpectedConditions.elementToBeClickable(btn_submit_loc)).click();
	 * }
	 * 
	 * public boolean checkLogoPresence() { try { WebElement logo =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(img_logo_loc));
	 * return logo.isDisplayed(); } catch (Exception e) {
	 * System.out.println("Logo not found or not visible: " + e.getMessage());
	 * return false; } }
	 */
}
