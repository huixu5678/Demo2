package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;

public class GridTest {


    public void testChrome() throws Exception{
        DesiredCapabilities dc=DesiredCapabilities.internetExplorer();
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.120:26870/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();

    }
    @DataProvider(name="data4")
    public Object[][] getdata(){
        return new Object[][]{
                {"firefox"},{"internetExplorer"}
        };
    }
    @Test(dataProvider ="data4")
    public void testGrid2(String browser) throws Exception {
        DesiredCapabilities dc=null;
        if(browser.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }else if(browser.equals("internetExplorer")){
            dc=DesiredCapabilities.internetExplorer();
        }
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.128:18702/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
        }

    }

