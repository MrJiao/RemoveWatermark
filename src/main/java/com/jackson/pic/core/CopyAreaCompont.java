package com.jackson.pic.core;

import com.jackson.pic.Config;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by: Jackson
 */
public class CopyAreaCompont {


    List<CopyArea> copyAreaList = new ArrayList<>();

    int width;//新图的宽
    int height;//新图的高

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<CopyArea> getCopyArea() {
        return copyAreaList;
    }

    ImageCompont.MyImage pic;
    BufferedImage bufImage;
    public void init(ImageCompont.MyImage pic) {
        bufImage = pic.getOutput();
        CopyArea timeArea = getTimeArea();
        CopyArea lineArea = getLineArea();
        CopyArea dateArea = getDateArea();
        CopyArea iconArea = getIconArea();
        CopyArea textArea = getTextArea();

        lineArea.topPadding=10;
        dateArea.toX=7;
        textArea.toX=7;

        addCopyArea(copyAreaList,timeArea);
        addCopyArea(copyAreaList,lineArea);
        addCopyArea(copyAreaList,dateArea);
        addCopyArea(copyAreaList,iconArea);
        addCopyArea(copyAreaList,textArea);
        calculateWidthAndHeight(copyAreaList);
        iconArea.toX = (width-iconArea.width)/2;

    }

    private void addCopyArea(List<CopyArea> copyAreaList,CopyArea copyArea){
        if(copyAreaList.size()==0){
            copyArea.toY = copyArea.topPadding;
        }else {
            CopyArea area = copyAreaList.get(copyAreaList.size() - 1);
            copyArea.toY = area.toY+area.height+area.bottomPadding+copyArea.topPadding;
        }
        copyAreaList.add(copyArea);
    }


    private CopyArea getTimeArea() {
        CopyArea area = new CopyArea();
        area.x = 71;
        area.y = 213;
        area.width = 1048;
        area.height = 94;
        return area;
    }

    private CopyArea getLineArea() {
        CopyArea area = new CopyArea();
        area.x = 71;
        area.y = 331;
        area.width = 1048;
        area.height = 12;
        return area;
    }

    private void calculateWidthAndHeight(List<CopyArea> copyAreaList) {
        for (CopyArea area : copyAreaList) {
            if(width<area.width){
                width = area.width;
            }
            height+=area.height+area.bottomPadding+area.topPadding;
        }

        width +=8;
        height +=8;

    }



    private CopyArea getDateArea(){
        CopyArea area = new CopyArea();
        area.x = 91;
        area.y = 348;
        area.width = 333;
        area.height = 118;

        return area;
    }

    private CopyArea getTextArea(){
        CopyArea area = new CopyArea();
        area.x = 91;
        area.y = 874;

        //差toY；

        a :for(int xi=bufImage.getWidth()-1;xi>0;xi--){
            for (int yi=874;yi<1569;yi++){
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    area.width = xi-91;
                    break a;
                }
            }
        }

        a :for(int yi=1569-1;yi>0;yi--){
            for (int xi=91;xi<bufImage.getWidth();xi++){
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    area.height = yi-874;
                    break a;
                }
            }
        }

        return area;
    }
    
    private CopyArea getIconArea(){

        CopyArea area = new CopyArea();
        int top=0;
        int bottom=0;
        int left=0;
        int right=0;

        a:for(int xi=bufImage.getWidth()-1;xi>0;xi--){
            for (int yi=466;yi<874;yi++){
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    right = xi;
                    break a;
                }
            }
        }

        a: for(int yi=874;yi>466;yi--){
            for (int xi=91;xi<bufImage.getWidth();xi++){
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    bottom = yi;
                    break a;
                }
            }
        }


        a :for(int xi=91;xi<right;xi++){
            for (int yi=466;yi<874;yi++){
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    left = xi;
                    break a;
                }
            }
        }

        a :for(int yi=438;yi<bottom;yi++){
            for (int xi=91;xi<bufImage.getWidth();xi++){
                if(yi<463 && xi<194)
                    continue ;
                int rgb = bufImage.getRGB(xi, yi);
                Color color = new Color(rgb);
                if(isEnoughDeep(color)){
                    top = yi;
                    break a;
                }
            }
        }

        area.x = left-2;
        area.y = top-2;
        area.width = right - left+5;
        area.height = bottom-top+5;
        area.topPadding = Config.topPadding;
        area.bottomPadding = Config.bottomPadding;
        return area;
    }

    private int deep = 200;//控制查找点颜色深度的
    private boolean isEnoughDeep(Color color){
        return color.getBlue()<deep || color.getGreen()<deep|| color.getRed()<deep;
    }
    

}
