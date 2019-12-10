import java.io.*;

/**
 * @author 喻浩
 * @create 2019-12-10-9:02
 * @Description:根据网页地址转换成图片
 */
public class GetScreenSnapshot {
    //空格
    private static String BLANK = " ";
    private static String separator;
    //创建新的文件，用以获取 当前项目的位置
    private static File file;
    //项目的基本路径
    private static String absolutePath;
    // 图片保存目录
    private static String imagePath;
    //无头浏览器的路径
    private static String phantomjsPath;
    //截图 js 脚本的路径
    private static String screenSnapshotJSPath;
    
    static {
        separator = File.separator;
        file = new File("");
        absolutePath = file.getAbsolutePath();
        phantomjsPath = absolutePath+separator+"External"+separator+"phantomjs.exe";
        screenSnapshotJSPath = absolutePath+separator+"External"+separator+"ScreenSnapshot.js";
    }

    // 执行cmd命令
    private static String cmd(String url) {
        return phantomjsPath+BLANK+screenSnapshotJSPath+BLANK+url+BLANK+imagePath;
    }
    /**
     * @param url
     * @throws IOException
     */
    public static boolean printUrlScreen2jpg(String url) throws IOException {
        
        imagePath = absolutePath+separator+"images"+separator+"baidu.png";//图片路径
        //Java中使用Runtime和Process类运行外部程序
        Process process = Runtime.getRuntime().exec(cmd(url));
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        if (reader.readLine() != null) {//成功
            reader.close();
            process.destroy();
            return true;
        } else {//失败
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "https://asset.mucang.cn/";//以百度网站首页为例
        GetScreenSnapshot.printUrlScreen2jpg(url);
    }
}