package com.jackson.common.update.net.request;

import com.jackson.common.update.net.domain.DownloadConfig;
import com.jackson.common.update.net.utils.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by: Jackson
 */
public class DownloadConfigRequest extends RequestAdapter<DownloadConfig> {
    String downloadConfigUrlStr;

    public DownloadConfigRequest(String downloadConfigUrlStr) {
        this.downloadConfigUrlStr = downloadConfigUrlStr;
    }

    @Override
    protected String getUrl() {
        return downloadConfigUrlStr;
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
    DownloadConfig parse(HttpEntity entity) throws Exception {
        String responseStr = EntityUtils.toString(entity);
        DownloadConfig downloadConfig = new DownloadConfig();
        String[] lines = responseStr.split("\n");
        for (String line : lines) {
            if(StringUtils.isEmpty(line))continue;
            if (line.startsWith("bat")){
                downloadConfig.setBatFileContent(line.split("=")[1].trim());
                continue;
            }else {
                String[] split = line.split(",");
                String url = split[0].trim();
                String path = split[1].trim();
                DownloadConfig.DownloadUrlConfig downloadUrlConfig = new DownloadConfig.DownloadUrlConfig();
                downloadUrlConfig.setPath(path);
                downloadUrlConfig.setUrl(url);
                downloadConfig.addDownLoadUrlList(downloadUrlConfig);
            }
        }
        return downloadConfig;
    }

    @Override
    String getType() {
        return "get";
    }
}
