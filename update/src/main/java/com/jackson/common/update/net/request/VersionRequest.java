package com.jackson.common.update.net.request;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by: Jackson
 */
public class VersionRequest extends RequestAdapter<Integer> {

    String url;
    public VersionRequest(String url) {
        this.url = url;
    }

    @Override
    protected String getUrl() {
        return url;
    }

    @Override
    Map<String, String> getParams() {
        return new HashMap<>();
    }

    @Override
    Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept"," text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding"," gzip, deflate, br");
        headers.put("Accept-Language"," zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Cache-Control"," no-cache");
        headers.put("Connection"," keep-alive");
        headers.put("Host"," coding.net");
        headers.put("Pragma"," no-cache");
        headers.put("Upgrade-Insecure-Requests"," 1");
        headers.put("User-Agent"," Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        return headers;
    }

    @Override
    Integer parse(HttpEntity entity) throws Exception {
        return Integer.parseInt(EntityUtils.toString(entity));
    }

    @Override
    String getType() {
        return "get";
    }
}
