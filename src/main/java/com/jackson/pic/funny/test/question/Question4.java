package com.jackson.pic.funny.test.question;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;

/**
 * Create by: Jackson
 */
public class Question4 extends BaseQuestion{

    @Override
    public FunnyBean initFunnyBean() {
        FunnyBean funnyBean = new FunnyBean();
        funnyBean.setTitle("");
        funnyBean.setSuccessMsg("");
        funnyBean.setUse(true);
        return funnyBean;
    }


    private FunnyQuestion question1() {
        FunnyQuestion funnyQuestion = new FunnyQuestion();
        funnyQuestion.setId("1");
        funnyQuestion.addQuestion("java.lang.SecurityException: Prohibited package name: java.patterns.v1");
        funnyQuestion.addQuestion("    at java.lang.ClassLoader.preDefineClass(ClassLoader.java:658)");
        funnyQuestion.addQuestion("    at java.lang.ClassLoader.defineClass(ClassLoader.java:794)");
        funnyQuestion.addQuestion("    at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)");
        funnyQuestion.addQuestion("Exception in thread \"main\" ");
        funnyQuestion.addAnswer("sdfsdklfdslkfjl123890123");
        funnyQuestion.setErrorChildId("1");
        return funnyQuestion;
    }


}
