package com.ackerm.httpClientDemo;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(get);

        StatusLine statusLine = response.getStatusLine();
        System.out.println(statusLine);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity, "utf-8");
        System.out.println("HttpClient调用" + url + "的返回内容：" + entityStr);
    }
}
