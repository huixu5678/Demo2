package selenium;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    public void test01(){
        System.setProperty("webdriver.gecko.driver", "E:\\eclipse_packages\\java_selenium_qudong\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.baidu.com");

    }
    @Test
    public void testIE(){
        System.setProperty("webdriver.ie.driver", "E:/eclipse_packages/java_selenium_qudong/IEDriverServer.exe");
        WebDriver driver= new InternetExplorerDriver();
        driver.get("http://www.baidu.com");

    }
}
