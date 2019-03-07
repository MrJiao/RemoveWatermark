package com.jackson.common.update;

import java.io.File;

/**
 * Create by: Jackson
 */
public class RuntimePath {

    public static String getRuntimePath() {
        if(UpdateCommpont.isPackage){
            String path = RuntimePath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            return new File(path).getParent();
        }else {
            return System.getProperty("user.dir");
        }

    }
}
