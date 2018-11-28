package com.jackson.pic.core;

import com.jackson.pic.utils.FileUtil;
import com.jackson.pic.utils.HappyInputUtil;
import com.jackson.pic.utils.L;
import com.jackson.pic.utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Create by: Jackson
 */
public class PicLoader {


    public Collection<File> loadPic(){
        File file = FileUtil.formatFile(new File(getFolderPath()));
        Collection<File> files = new ArrayList<>();
        if(file.isFile()){
            if(file.getName().endsWith(".jpg")||file.getName().endsWith(".JPG")){
                files.add(file);
            }
        }else {
            files = getPicFile(file);
        }
        return files;
    }


    private static String getFolderPath() {
        String input ="";
        while (true) {
            try {
                L.d("请输入文件或文件夹全路径");
                input = HappyInputUtil.getInput();
                if(!StringUtils.isEmpty(input))
                    break;
            } catch (Exception e) {
                L.d("输入错误");
            }
        }
        if(input.charAt(0)==34 && input.charAt(input.length()-1)==34)
            input = input.substring(1,input.length()-1);
        return input;
    }

    static List<File> picFile = new ArrayList<>();
    private static List<File> getPicFile(File folderPath){
        L.d("扫描文件夹:"+folderPath.getName());
        File[] files = folderPath.listFiles();
        for (File f : files) {
            if(f==null)continue;
            f = FileUtil.formatFile(f);
            if(f.isDirectory()){
                getPicFile(f);
            }else if(f.getName().endsWith(".jpg")){
                picFile.add(f);
            }
        }
        return picFile;
    }

}
