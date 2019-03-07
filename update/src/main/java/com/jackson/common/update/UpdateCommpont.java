package com.jackson.common.update;

import com.jackson.common.update.net.domain.DownloadConfig;
import com.jackson.common.update.net.request.DownloadConfigRequest;
import com.jackson.common.update.net.request.DownloadRequest;
import com.jackson.common.update.net.request.VersionRequest;
import com.jackson.common.update.util.FileUtil;
import com.jackson.common.update.util.L;
import org.apache.commons.io.FileUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Create by: Jackson
 */
public class UpdateCommpont {

    public static boolean isPackage = true;
    String versionUrl;
    public static int versionCode;
    String downloadConfigUrlStr;
    File runtimeFolder;
    public UpdateCommpont(int versionCode,String versionUrl, String downloadConfigUrlStr) {
        this.versionUrl = versionUrl;
        this.downloadConfigUrlStr = downloadConfigUrlStr;
        this.versionCode = versionCode;
        runtimeFolder = FileUtil.formatFile(new File(RuntimePath.getRuntimePath()));
    }


    public boolean update() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        if(!checkVersion(client)){
            System.out.println("当前为最新版本，不需要更新");
            return false;
        }
        L.d("正在更新中，请勿关闭");
        DownloadConfig downloadConfig = new DownloadConfigRequest(downloadConfigUrlStr).request(client);

        writeBat(downloadConfig.getBatFileContent());

        downloadFile(client,downloadConfig.getDownLoadUrlList());
        L.d("更新完成，请重启");
        return true;
    }

    private void writeBat(String batFileContent) throws IOException {
        File batFile = new File(runtimeFolder.getParent(), "start.bat");
        FileUtils.write(batFile,batFileContent, Charset.defaultCharset());
    }

    private void downloadFile(CloseableHttpClient client, List<DownloadConfig.DownloadUrlConfig> downLoadUrlList) {
        for (DownloadConfig.DownloadUrlConfig downloadUrlConfig : downLoadUrlList) {
            File file = new File(runtimeFolder, downloadUrlConfig.getPath());
            file.getParentFile().mkdirs();
            String url = downloadUrlConfig.getUrl();
            new DownloadRequest(url,file).request(3,client);
        }
    }

    private boolean checkVersion(CloseableHttpClient client) {
        Integer versionCode = new VersionRequest(versionUrl).request(client);
        return versionCode>this.versionCode;
    }

}
