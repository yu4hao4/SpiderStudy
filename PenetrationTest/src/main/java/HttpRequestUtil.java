import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Http请求工具类 
 * @author snowfigure
 * @since 2014-8-24 13:30:56 
 * @version v1.0.1
 */
public class HttpRequestUtil {
//    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://blog.csdn.net/z1790424577/article/details/82938624");
//
//        // 打开和url之间的连接
//        URLConnection connection = url.openConnection();
//
//        // 设置请求参数
//        connection.setRequestProperty("user-agent", "javasec");
//        connection.setConnectTimeout(1000);
//        connection.setReadTimeout(1000);
//        // 建立实际连接
//        connection.connect();
//
//        // 获取响应头字段信息列表
//        Map<String, List<String>> headerFields = connection.getHeaderFields();
//        for (String s : headerFields.keySet()) {
//            System.out.println(s);
//        }
//
//        // 获取URL响应
//        connection.getInputStream();
//
//        System.out.println(connection.getLastModified());
//
////        StringBuilder response = new StringBuilder();
////        BufferedReader in = new BufferedReader(
////                new InputStreamReader(connection.getInputStream()));
////        String line;
////
////        while ((line = in.readLine()) != null) {
////            response.append("/n").append(line);
////        }
//
////        System.out.print(response.toString());
//
//
//    }


    public static void main(String[] args) {
        
        try {
            String urlAddress = "https://www.cnblogs.com/itcqx/p/5683961.html";
            URL url = new URL(urlAddress);
            System.out.println("ip"+getIP(url.getHost()));
            System.out.println("port"+url.getPort());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            //接受并转码（很重要，不然会乱码）
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String sCurrentLine;
            StringBuilder htmlResponseBody = new StringBuilder();
            while ((sCurrentLine = bufferedReader.readLine()) != null){
                htmlResponseBody.append(sCurrentLine);
            }

//            System.out.println(htmlResponseBody.toString());
            System.out.println(getTitle(String.valueOf(htmlResponseBody)));
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date(connection.getLastModified());
//            System.out.println("last modify"+connection.getLastModified());
//            System.out.println("now time"+System.currentTimeMillis());
//            System.out.println("last time"+simpleDateFormat.format(date));
//            System.out.println("now time"+simpleDateFormat.format(System.currentTimeMillis()));
            for (int i = 1; ; i++) {
                String header = connection.getHeaderField(i);
                if (header == null) {
                    break;
                }
//                System.out.println(connection.getHeaderFieldKey(i)+": "+header);
            }
        } catch (IOException e) {

        }
    }

    /**
     * 通过域名获取真实的ip地址 (此方法需要在线程中调用)
     *
     * @param domain
     * @return
     */
    public static String getIP(String domain) {
        String ipAddress = "";
        InetAddress iAddress = null;
        try {
            iAddress = InetAddress.getByName(domain);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (iAddress == null){
//            Log.i("xxx", "iAddress ==null");
        }else {
            ipAddress = iAddress.getHostAddress();
        }
        return ipAddress;
    }

    /**
     * 获取url对应的域名
     *
     * @param url
     * @return
     */
    public static String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2)
                    startIndex = i;
                else if (j == 3)
                    endIndex = i;
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }


    /**
     *
     * @param s
     * @return 获得网页标题
     */
    public static String getTitle(final String s)
    {
        String regex;
        StringBuilder title = new StringBuilder();
        final List<String> list = new ArrayList<String>();
        regex = "<title>.*?</title>";
        final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
        final Matcher ma = pa.matcher(s);
        while (ma.find())
        {
            list.add(ma.group());
        }
        for (String value : list) {
            title.append(value);
        }
        return outTag(title.toString());
    }

    /**
     *
     * @param s
     * @return 获得脚本代码
     */
    public List<String> getScript(final String s)
    {
        String regex;
        final List<String> list = new ArrayList<String>();
        regex = "<script.*?</script>";
        final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        final Matcher ma = pa.matcher(s);
        while (ma.find())
        {
            list.add(ma.group());
        }
        return list;
    }

    /**
     *
     * @param s
     * @return 去掉标记
     */
    public static String outTag(final String s)
    {
        return s.replaceAll("<.*?>", "");
    }
}