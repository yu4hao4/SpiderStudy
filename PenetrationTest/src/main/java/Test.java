import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author 喻浩
 * @create 2019-12-06-1:07
 */
public class Test {

    //代码所处位置
    private static String codeAddress = new File("").getAbsolutePath()+File.separator;
    // driver 包所处位置
    private static String chromeDriverAddress = codeAddress+"chromedriver.exe";
    private static WebDriver driver;
    //正则对象
    private static Pattern pattern;
    //url 正则
    // ^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
    private static String urlRegex = "^[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    // 静态代码块，初始化 chrome 浏览器的 driver 包
    static {
        System.setProperty("webdriver.chrome.driver", chromeDriverAddress);

        ChromeOptions chromeOptions=new ChromeOptions();
        //设置 chrome 的无头模式
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        // 创建了一个 Chrome driver 的实例
        driver = new PhantomJSDriver();
        driver = new ChromeDriver(chromeOptions);
    }

    public static void main(String[] args) throws Exception {
        //https://blog.csdn.net/qq_25384945/article/details/81219075
//        getScreenPhoto("www.baidu.com");
        getScreenPhoto("blog.csdn.net/qq_25384945/article/details/81219075");
    }

    /**
     * 获取传入 url 的截图
     * @param url
     * @throws Exception
     */
    private static void getScreenPhoto(String url) throws Exception {
        pattern = Pattern.compile(urlRegex);
        if(!pattern.matcher(url).matches()){
            throw new Exception(url+"不是url，请输入正确的URL地址");
        }

        driver.get("https://"+url);

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(codeAddress + "ScreenImages/"+url+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
