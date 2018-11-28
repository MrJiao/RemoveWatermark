package com.jackson.pic;

import com.jackson.pic.core.AreaCompont;
import com.jackson.pic.core.ImageCompont;
import com.jackson.pic.utils.L;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Create by: Jackson
 */
public class Task extends Thread {

    Collection<File> fileList;
    ImageCompont imageCompont;
    public Task( Collection<File> list){
        this.fileList = list;
        imageCompont = new ImageCompont();
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();

        for (File file : fileList) {
            try {
                imageCompont.handle(file);
                L.d("处理完成:"+file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时 " + (end - start) / 1000 + " 秒");

    }




}
