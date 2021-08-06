import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class localHtmlTest {

    public void localtest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\Skylancer T2\\Desktop\\work-out-git\\index.html");
        driver.findElement(By.xpath("/html/body/center[1]/button")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/center[1]/button")).getText());
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"set\"]")));
        if (driver.findElement(By.xpath("//*[@id=\"set\"]")).getText().equalsIgnoreCase("this is my first html file!")) {
            System.out.println("working as intended ");
        } else {
            System.out.println("you have a lot to learn");
        }
        driver.quit();
    }
}
