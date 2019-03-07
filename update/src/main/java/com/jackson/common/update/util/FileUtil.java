package com.jackson.common.update.util;

import java.io.File;

/**
 * Create by: Jackson
 */
public class FileUtil {


    public static File formatFile(File file){
        return new File(file.toURI().getPath());
    }
}
