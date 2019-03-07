package com.jackson.common.update.net.request;

import org.apache.http.HttpEntity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by: Jackson
 */
public class DownloadRequest extends RequestAdapter<String> {

    File file;
    String url;
    public DownloadRequest(String url, File storeFile) {
        this.file = storeFile;
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
        return headers;
    }

    @Override
    String parse(HttpEntity entity) throws Exception {
        BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream(file));
        entity.writeTo(bfs);
        bfs.flush();
        bfs.close();
        return "ok";
    }

    @Override
    String getType() {
        return "get";
    }
}
