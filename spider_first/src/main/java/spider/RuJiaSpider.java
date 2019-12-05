package spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.client.HttpClient;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

/**
 * @author 喻浩
 * @create 2019-09-25-10:49
 */
public class RuJiaSpider {
    public static void main(String[] args) throws URISyntaxException, IOException {
//        https://hotels.ctrip.com/brand/h912/
        //https://hotels.ctrip.com/brand/h912/
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        URI uri = new URIBuilder()
//                .setScheme("https")
//                .setHost("hotels.ctrip.com")
//                .setPath("/brand/h912/").build();
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("hotels.ctrip.com")
                .setPath("/hotel/1282089.html").build();

//        HttpGet httpGet = new HttpGet(uri);
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//        String html = EntityUtils.toString(response.getEntity(),"utf-8");
//        Document document = Jsoup.parse(html);
//        Document document = Jsoup.connect("https://hotels.ctrip.com/hotel/1282089.html").get()  ;
//        System.out.println(document);
//        System.out.println(document.select("div#hotel_list>div.hotel_new_list.J_HotelListBaseCell").first().getElementsByAttribute("id"));
//        Elements hotalName = document.select("div.hotel_new_list.J_HotelListBaseCell>ul.hotel_item" +
//                ">li.hotel_item_name>h2.hotel_name>a");
//        Elements hotalPrice = document.getElementsByClass( "hotel_name");
//        System.out.println(hotalPrice.isEmpty());

//        Iterator iterator = hotalName.iterator();
//        Iterator iterator1 = hotalPrice.iterator();
//
//        while(iterator.hasNext() && iterator1.hasNext()){
//            Element element1 = (Element)iterator.next();
//            Element element2 = (Element)iterator1.next();
//            System.out.println(element1.text() +"   "+ element2.text());
//        }

//        for(Element element : hotalPrice){
//            System.out.println(element.text());
//        }

        WebClient wc=new WebClient(BrowserVersion.CHROME);
        wc.setJavaScriptTimeout(5000);
        wc.getOptions().setUseInsecureSSL(true);//接受任何主机连接 无论是否有有效证书
        wc.getOptions().setJavaScriptEnabled(true);//设置支持javascript脚本 
        wc.getOptions().setCssEnabled(false);//禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(false);//js运行错误时不抛出异常
        wc.getOptions().setTimeout(100000);//设置连接超时时间
        wc.getOptions().setDoNotTrackEnabled(false);
        HtmlPage page=wc.getPage("http://hotels.ctrip.com/brand/h912/");

        String res=page.asXml();

        System.out.println(res);
    }
}
