package com.ackerm.httpClientDemo;

import com.renfufei.homework02.OkHttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpDemo {
    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String respnseStr = response.body().string();
        System.out.println("OkHttp调用" + url + "的返回内容：" + respnseStr);

        // 清理资源
        OkHttpUtils.client = null;
    }
}
