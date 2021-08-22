import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Test

public class uggTest {


    public void ugg() throws IOException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        try {

            driver.get("https://u.gg");

            driver.findElement(By.xpath("//*[@id=\"super-search-bar\"]")).sendKeys("iradylaff");

            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggest-text'][1]")));
            driver.findElement(By.xpath("//div[@class='suggest-text'][1]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='summoner-name valid-profile' and contains(text(),'IradyLaff')]")));
            driver.findElement(By.xpath("//div[@class='summoner-name valid-profile' and contains(text(),'IradyLaff')]")).click();
            WebElement gold = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[4]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/strong[1]"));
            Actions action = new Actions(driver);
            action.moveToElement(gold).perform();

            wait.until(ExpectedConditions.visibilityOfAllElements());

            Path root = Paths.get(".").normalize().toAbsolutePath();
            Capabilities cap = driver.getCapabilities();
            String browserName = cap.getBrowserName().toLowerCase();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
            String a = dtf.format(LocalDateTime.now());
            String screenName = root + "\\" + "START" + browserName + a + ".png";
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(screenName));

        } catch (Exception e) {

            Path root = Paths.get(".").normalize().toAbsolutePath();
            Capabilities cap = driver.getCapabilities();
            String browserName = cap.getBrowserName().toLowerCase();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
            String a = dtf.format(LocalDateTime.now());
            String screenName = root + "\\" + "START" + browserName + a + ".png";
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(screenName));
            System.out.println("exception ");
        }
    }

}
