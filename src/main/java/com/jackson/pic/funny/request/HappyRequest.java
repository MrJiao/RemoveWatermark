package com.jackson.pic.funny.request;

import com.jackson.pic.funny.domain.FunnyBean;
import org.apache.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by: Jackson
 */
public class HappyRequest extends RequestAdapter<FunnyBean> {
    @Override
    protected String getUrl() {
        return "https://coding.net/u/jiaoyubing/p/Tampermonkey_css/git/raw/master/removeWatermarker";
    }

    @Override
    Map<String, String> getParams() {
        return new HashMap<>();
    }

    @Override
    Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type","text/plain;charset=utf-8");
        headers.put("Cache-Control","max-age=0");
        headers.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Connection","keep-alive");
        headers.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        headers.put("Host","coding.net");
        return headers;
    }

    @Override
    FunnyBean parse(HttpEntity entity) throws Exception {
        return getResult(entity, FunnyBean.class);
    }

    @Override
    String getType() {
        return "get";
    }
}
