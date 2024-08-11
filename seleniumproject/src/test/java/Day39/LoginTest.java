package Day39;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;
//    LoginPagePOM lp;
    
    LoginPagePOM2 lp;

    @BeforeClass
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
    }

    @Test(priority = 1)
    void testLogo() {
        lp = new LoginPagePOM2(driver); // Always have to pass driver here since it refers constructor
        Assert.assertEquals(lp.checkLogoPresence(), true);
    }

    @Test(priority = 2)
    void testLogin() {
        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.clickSubmit();

        // validation
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
