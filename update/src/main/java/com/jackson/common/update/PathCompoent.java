package com.jackson.common.update;

import java.io.File;

/**
 * Create by: Jackson
 */
public class PathCompoent {


    public String getRuntimePath() {
        if(UpdateCommpont.isPackage){
            String path = RuntimePath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            return new File(path).getParent();
        }else {
            return System.getProperty("user.dir");
        }
    }

    public File getResourceFilePath(){
        File file = new File(getRootFile(), "/version/" + UpdateCommpont.versionCode+"/resource");
        file.mkdirs();
        return file;
    }

    public File getJarFilePath(){
        File file = new File(getRootFile(), "/version/" + UpdateCommpont.versionCode);
        file.mkdirs();
        return file;
    }


    public File getRootFile(){
        return new File(getRuntimePath()).getParentFile().getParentFile();
    }


}
