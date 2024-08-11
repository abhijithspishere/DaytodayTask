package Day28;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class blazeDemoAssignmentEndtoEnd {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement departure = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departureDrop = new Select(departure);
        departureDrop.selectByVisibleText("Boston");

        WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select destinationDrop = new Select(destination);
        destinationDrop.selectByVisibleText("Berlin");

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();

        // Array to store prices
        double[] prices = new double[rows - 2]; // Subtracting 2 as we start from row 2
        int index = 0; // Index for storing prices in the array

        for (int r = 2; r < rows; r++) {
            // Getting the price from the table cell
            String price = driver.findElement(By.xpath("//table[@class='table']//tr[" + r + "]//td[6]"))
                    .getText();

            // Replacing "$" and converting price to double
            price = price.replace("$", "");
            double convertedPrice = Double.parseDouble(price);

            // Storing price in the array
            prices[index] = convertedPrice;
            index++;
        }

        // Finding the smallest price
        double smallestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < smallestPrice) {
                smallestPrice = prices[i];
            }
        }

        // Printing the smallest price
        System.out.println("Smallest Price: $" + smallestPrice);

        // Closing the WebDriver instance
        driver.quit();
    }
}
