package com.cta.homework3.httpClient;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientHelper {

    public static CloseableHttpClient httpclient = HttpClients.createDefault();

    // GET 调用
    public static String getAsString(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println("返回状态："+response1.getStatusLine().getStatusCode());
            HttpEntity entity1 = response1.getEntity();
            String html = EntityUtils.toString(entity1, "UTF-8");
            EntityUtils.consume(entity1);
            return html;
        } finally {
            if (null != response1) {
                response1.close();
            }
            httpGet.releaseConnection();
            httpclient.close();
        }
    }


    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8088/hello2";
//        URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8801).build();
        String text = HttpClientHelper.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

    }
}
