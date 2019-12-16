package spider;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 喻浩
 * @create 2019-09-24-9:21
 */
public class FirstSpider {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        Document doc = Jsoup.connect("https://www.csdn.net/").get();
//        //CSDN-专业IT技术社区
////        System.out.println(doc.title()); 
//        //把文章标题和连接写入txt文件
//        Elements title = doc.getElementsByClass("title");
//        Elements h2 = title.select("h2");
//        Elements a = h2.select("a");
//        //打印
//        for (Element element : a) {
//            System.out.println(element.text());
//            System.out.println(element.attr("href"));
//        }
        
        
        //https://blog.csdn.net/championhengyi/article/details/68491306
        

        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("blog.csdn.net")
                .setPath("/championhengyi/article/details/68491306").build();
//                .setParameter("wd","jsoup%E5%92%8Chttpcient%E7%BB%93%E5%90%88").build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);
//        System.out.println(response.getStatusLine().getStatusCode());
//        System.out.println(EntityUtils.toString(response.getEntity()));
        String html = EntityUtils.toString(response.getEntity(),"utf-8");
        Document document = Jsoup.parse(html);
//        System.out.println(document);
        Elements h3 = document.select("div.article-title-box>h1");
//        System.out.println(h3.isEmpty());
        for (Element element : h3) {
            System.out.println(element.attributes());
        }
    }
}
