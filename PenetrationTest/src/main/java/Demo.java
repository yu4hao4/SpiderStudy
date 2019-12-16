import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * @author 喻浩
 * @create 2019-12-12-18:39
 */
public class Demo {
    //代码所处位置
    private static String codeAddress = new File("").getAbsolutePath()+File.separator;
    // driver 包所处位置
    private static String chromeDriverAddress = codeAddress+"chromedriver.exe";

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", chromeDriverAddress);
//        WebDriver driver=new ChromeDriver();//谷歌浏览器
//        driver.get("http://fanyi.baidu.com/");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//        driver.navigate().refresh();
//        driver.close();//关闭驱动
//        driver.quit();
//        JSONObject jsonObject = HttpRequestUtil.httpRequest("http://fanyi.baidu.com/", "GET", "");
//        System.out.println(jsonObject.toJSONString());
    }

}