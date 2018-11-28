package com.jackson.pic.funny.utils;


import com.jackson.pic.utils.L;

import java.util.List;

/**
 * Create by: Jackson
 */
public class HappyLogUtil {


    public static void title(String title) {
        L.console(title);
    }

    public static void content(List<String> content){
        if(content == null || content.size()==0)return;
        HappyLogUtil.line();
        for (String s : content) {
            p(s);
        }
        HappyLogUtil.line();
    }


    public static void question(List<String> question) {
        for (String s : question) {
            p(s);
        }
    }


    public static void errerMsg(List<String> errorMsg) {
        for (String s : errorMsg) {
            p(s);
        }
    }

    public static void p(String msg) {
        if(StringUtils.isEmpty(msg))return;
        System.out.println(msg);
    }

    public static void inputError(String errorMsg) {
        System.out.println(errorMsg);
    }


    public static void normal(String msg){
        p(msg);
    }

    public static void successMsg(String successMsg) {
        L.console(successMsg);
    }

    public static void line() {
        p("---------------------------------------");
    }
}
