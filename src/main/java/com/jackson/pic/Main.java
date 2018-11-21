package com.jackson.pic;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Create by: Jackson
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(getFolderPath());
        //Collection<File> files = FileUtils.listFiles(folder, new String[]{"jpg"}, true);
        Collection<File> files = new ArrayList<>();
        if(file.isFile()){
            if(file.getName().endsWith(".jpg")||file.getName().endsWith(".JPG")){
                files.add(file);
            }
        }else {
            files = getPicFile(file);
        }
        Task task = new Task(files);
        task.start();
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
        return input;
    }

    static List<File> picFile = new ArrayList<>();
    private static List<File> getPicFile(File folderPath){
        L.d("扫描文件夹:"+folderPath.getName());
        File[] files = folderPath.listFiles();
        for (File f : files) {
            if(f==null)continue;
            if(f.isDirectory()){
                getPicFile(f);
            }else if(f.getName().endsWith(".jpg")){
                picFile.add(f);
            }
        }
        return picFile;
    }


}
