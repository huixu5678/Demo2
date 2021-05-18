package selenium;





import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TestCase1 {
    WebDriver driver;

    public void test01(){
        String a="aaa";
        String b="aaa";
        String c="aaa";
        Assert.assertEquals(a,b,"a!=b");
        Assert.assertNotEquals(a,c,"a!=c");
        Assert.assertNull(a);
        Assert.assertNotNull(b);

    }


    public void testChrome(){
        System.setProperty("webdriver.chrome.driver", "E:/eclipse_packages/java_selenium_qudong/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
    }

    public void testIE(){
        System.setProperty("webdriver.ie.driver", "E:/eclipse_packages/java_selenium_qudong/IEDriverServer.exe");
 		driver= new InternetExplorerDriver();

    }

    public void testFireFox(){
        System.setProperty("webdriver.gecko.driver", "E:\\eclipse_packages\\java_selenium_qudong\\geckodriver.exe");
 	    System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
        driver=new FirefoxDriver();
    }
    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver", "E:/eclipse_packages/java_selenium_qudong/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void testShot()throws Exception{
        driver.get("http://www.baidu.com");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("D:/test1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        WebElement we=driver.findElement(By.xpath("//*[@id=\"hotsearch-content-wrapper\"]/li[1]/a/span[2]"));
        we.click();
        Set<String> hands= driver.getWindowHandles();
        String hand=driver.getWindowHandle();
        System.out.println("hand--------"+hand);
        for(String str : hands){
            if(str.equals(hand))
                continue;
            driver.switchTo().window(str);
        }
        driver.findElement(By.xpath("//*[@id=\"1\"]/div/div[1]/div/div[2]/p/a/span")).click();
        String hand2=driver.getWindowHandle();
        Set<String> hands2= driver.getWindowHandles();
        System.out.println("hand2--------"+hand2);
        for(String str : hands2){
            Thread.sleep(1000);
            if(str.equals(hand2))
                continue;
            driver.switchTo().window(str);
            driver.close();

        }
    }

    public void actionTest1()throws Exception{
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
//      actions.contextClick(driver.findElement(By.id("su"))).perform();  右击
        WebElement she=driver.findElement(By.xpath("//*[@id=\"s-usersetting-top\"]"));
        actions.moveToElement(she).perform();//移动到元素上面
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"s-user-setting-menu\"]/div/a[1]")).click();
        Thread.sleep(3000);

    }
    public void waitTest(){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("..............")));
    }
    public void RobotTest() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Actions actions=new Actions(driver);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }


    public void DownLoadJdkTest() throws Exception {
        driver.get("https://www.cr173.com/soft/79926.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"bddown\"]/i")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"download\"]/div[1]/ul[1]/li[1]/a")).click();
        Thread.sleep(2000);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);

    }
    @Test
    public void JStest(){
        //driver.get("https://mail.qq.com/");
        driver.get("http://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"8989\")");

    }
    public void timeTest(){
        //时间戳
        long time=System.currentTimeMillis();//毫秒
        //转换为秒    /100
        String.valueOf(time);

    }

    public void close(){

        driver.quit();
    }

    public void switchtoAlter(){
        Alert alert=driver.switchTo().alert();
        alert.accept();//确定
    }


}
