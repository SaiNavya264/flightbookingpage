import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FlightBookingPageTest {
    public static void main(String[]args){
        try{
            System.setProperty("webdriver.chrome.driver","C:\\Users\\saina\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get("https://qaflightbooking.ccbp.tech/");
            WebElement departure=driver.findElement(By.cssSelector("input#departureCity"));
            departure.sendKeys("New York");
            WebElement dstntn=driver.findElement(By.cssSelector("input#destinationCity"));
            dstntn.sendKeys("Los Angeles");
            WebElement date=driver.findElement(By.cssSelector("input#travelDate"));
            date.sendKeys("01/08/2023");
            WebElement count=driver.findElement(By.cssSelector("input#passengers"));
            count.sendKeys("2");
            String expectedUrl="https://qaflightbooking.ccbp.tech/";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Wait until the URL to be expected URL
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            // Verify the navigation to the Review page
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigated to home page");
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
            WebElement search=driver.findElement(By.id("searchBtn"));
            search.click();
            WebElement flight=driver.findElement(By.name("flight"));
            flight.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            WebElement book=driver.findElement(By.tagName("button"));
            book.click();
            System.out.println("$500");
            WebElement pswrd=driver.findElement(By.cssSelector("input[type='password']"));
            pswrd.sendKeys("traveler123");
            WebElement pay=driver.findElement(By.tagName("button"));
            pay.click();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
            System.out.println("Booking Success");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
