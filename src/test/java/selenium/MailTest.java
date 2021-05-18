package selenium;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailTest {
    WebDriver driver;
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.gecko.driver", "E:\\eclipse_packages\\java_selenium_qudong\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
        driver=new FirefoxDriver();
    }

    @Test
    public void test_126mail()throws Exception{
        driver.get("https://www.126.com/");
        WebElement frame=driver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe')]"));
        driver.switchTo().frame(frame);
        //driver.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys("18173028921");
        driver.findElement(LoginPage.emailInput).sendKeys("huihui19901208");
        driver.findElement(LoginPage.pwdInput).sendKeys("huixu5678");
        driver.findElement(LoginPage.loginButton).click();

    }
}
