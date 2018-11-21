package com.jackson.pic;

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
    AreaCompont areaCompont;
    public Task( Collection<File> list){
        this.fileList = list;
        areaCompont = new AreaCompont();
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();

        for (File file : fileList) {
            try {
                remove(file);
                L.d("处理完成:"+file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时 " + (end - start) / 1000 + " 秒");

    }

    public  void remove(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        int height = image.getHeight();
        int width = image.getWidth();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = output.createGraphics();
        int a = 210;
        graphics.drawImage(image, 0, 0, null); //画图
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(!areaCompont.isContains(i,j))continue;
                int rgb = image.getRGB(i, j);
                Color color = new Color(rgb);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                if (red > a && blue > a && green > a) {
                    output.setRGB(i, j, -1);

                }
            }
        }
        ImageIO.write(output, "jpg", file);
    }




}
