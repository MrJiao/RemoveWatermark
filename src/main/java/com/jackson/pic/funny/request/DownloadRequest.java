package com.jackson.pic.funny.request;

import org.apache.http.HttpEntity;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by: Jackson
 */
public class DownloadRequest extends RequestAdapter<String> {

    File file;

    public DownloadRequest(File storeFile) {
        this.file = storeFile;
    }

    @Override
    protected String getUrl() {
        return "https://coding.net/api/share/download/b4b722fe-9292-4520-b8a3-39b758a8980d";
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
