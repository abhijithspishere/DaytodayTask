package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;

public class handlinFrames {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tinymce");

        // Switch to the iframe containing the editor
        driver.switchTo().frame("mce_0_ifr");

        // Find and clear the editor content
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();

        // Type the text "Abhijith" into the editor
        editor.sendKeys("This is asp");

        // Select the entire text "Abhijith"
        editor.sendKeys(Keys.CONTROL+"A");

        // Switch back to the default content (i.e., outside the iframe)
        driver.switchTo().defaultContent();

        // Close the browser
//        driver.quit();
    }
}
