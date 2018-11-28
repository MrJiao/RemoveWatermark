package com.jackson.pic;

import com.jackson.pic.core.PicLoader;
import com.jackson.pic.funny.HappyTime;
import com.jackson.pic.utils.L;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Create by: Jackson
 */
public class Main {

    public static void main(String[] args) throws IOException {
        L.d("加载中...");
        HappyTime.start();
        Collection<File> files = new PicLoader().loadPic();
       // Collection<File> files =get();
        Task task = new Task(files);
        task.start();
    }

    public static    Collection<File> get(){
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("/Users/jiaoyubing/work_space/localworkspace/remove_watermark/target/test/1001.jpg"));
        return files;
    }



}
