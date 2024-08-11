package Day36;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) throws IOException {
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        String exp_title = "nopCommerce demo store";
        String act_title = driver.getTitle();

        Assert.assertEquals(exp_title, act_title);
    }

    @AfterClass
    void tearDown() {
        driver.close();
    }

    @DataProvider(name = "dp")
    Object[][] loginData() throws IOException {
        String file = System.getProperty("user.dir") + "C:\\Users\\abhij\\eclipse-workspace\\seleniumproject\\testdata\\dpwithexcel.xlsx";

        // Check if file exists
        File f = new File(file);
        if (!f.exists()) {
            System.err.println("Excel file not found: " + file);
            return new Object[0][0]; // Return empty data if file is missing
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            System.err.println("Error opening Excel file: " + e.getMessage());
            return new Object[0][0]; // Return empty data on error
        }

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];
        DataFormatter formatter = new DataFormatter();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = formatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }

        workbook.close();

        return data;
    }
}
