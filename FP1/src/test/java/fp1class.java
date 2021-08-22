import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class fp1class {


    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setBrowser(String browser) throws Exception {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            throw new Exception("Browser is not correct");
        }

    }

    @Test
    public void mainTEst() throws InterruptedException {

        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("aaa");
        Path root = Paths.get(".").normalize().toAbsolutePath();
        System.out.println(root);


    }

//    @AfterTest
//    public void terminate() {
//        driver.quit();
//    }

}
