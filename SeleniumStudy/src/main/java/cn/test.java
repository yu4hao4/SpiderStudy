package cn;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * @author 喻浩
 * @create 2019-09-25-19:58
 */
public class test {
//    WebDriver driver = new ChromeDriver();    //Chrome浏览器

//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
//
////        ChromeOptions chromeOptions = new ChromeOptions();
////        chromeOptions.addArguments("--headless");
////        WebDriver driver = new ChromeDriver(chromeOptions);
//        
//        WebDriver driver= new ChromeDriver();
//        driver.get("https://www.baidu.cn");
//
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//
//        driver.get("https://m.baidu.cn");
//        driver.manage().window().setSize(new Dimension(480, 800));
//        Thread.sleep(2000);
//
//        driver.quit();
//    }

    //截图
//    public static void main(String[] arge) {
//        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.baidu.com");
//
//        
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        try {
//            FileUtils.copyFile(srcFile, new File("d:\\screenshot.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        driver.quit();
//    }


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        // 创建了一个 Firefox driver 的实例
        // 注意，其余的代码依赖于接口而非实例
        WebDriver driver = new ChromeDriver();

        // 使用它访问 Google
        driver.get("http://www.baidu.com");
        // 同样的事情也可以通过以下代码完成
        // driver.navigate().to("http://www.google.com");

        // 找到搜索输入框
        WebElement element = driver.findElement(By.name("wd"));

        // 输入要查找的词
        element.sendKeys("Cheese!");

        // 提交表单
        element.submit();

        // 检查页面标题
        System.out.println("Page title is: " + driver.getTitle());

        // Google 搜索结果由 JavaScript 动态渲染
        // 等待页面加载完毕，超时时间设为10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        //应该能看到: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //关闭浏览器
        driver.quit();
    }
}
