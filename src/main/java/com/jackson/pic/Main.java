package com.jackson.pic;

import com.jackson.common.update.UpdateCommpont;
import com.jackson.pic.core.PicLoader;
import com.jackson.pic.core.Task;
import com.jackson.pic.funny.HappyTime;
import com.jackson.pic.utils.L;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Create by: Jackson
 */
public class Main {

    public static void main(String[] args) throws IOException {
/*        L.d("当前版本:"+Config.version);
        UpdateCommpont updateCommpont = new UpdateCommpont(Config.versionCode,
                Config.versionUrl,
                Config.downloadConfigUrl);
        try {
            if(updateCommpont.update()){
                return;
            }
        }catch (Exception e){
            L.d("更新失败");
        }*/

        L.d("加载中...");
        HappyTime.start();
        Collection<File> files = new PicLoader().loadPic();
        //Collection<File> files =get();
        Task task = new Task(files);
        task.start();
    }

    public static    Collection<File> get(){
        String path = "/Users/jiaoyubing/work_space/localworkspace/remove_watermark/target/北京";
      //  String path = "/Users/jiaoyubing/work_space/localworkspace/remove_watermark/target/北京/1621---抢注人.jpg";
        File file = new File(path);
        ArrayList<File> files = new ArrayList<>();
        if(file.isFile()){
            files.add(file);
        }else {
            File[] files1 = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".jpg");
                }
            });
            for (File f : files1) {
                files.add(f);
            }
        }
        return files;
    }



}
