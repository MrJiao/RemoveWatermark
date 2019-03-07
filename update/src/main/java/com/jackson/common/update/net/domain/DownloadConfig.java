package com.jackson.common.update.net.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by: Jackson
 */
public class DownloadConfig {

    List<DownloadUrlConfig> downLoadUrlList = new ArrayList<>();

    String batFileContent;

    public List<DownloadUrlConfig> getDownLoadUrlList() {
        return downLoadUrlList;
    }

    public void addDownLoadUrlList(DownloadUrlConfig downLoadUrl) {
        this.downLoadUrlList.add(downLoadUrl);
    }

    public String getBatFileContent() {
        return batFileContent;
    }

    public void setBatFileContent(String batFileContent) {
        this.batFileContent = batFileContent;
    }


    public static class DownloadUrlConfig{
        String url;
        String path;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }


}
