package com.jackson.pic.funny.test.question;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;

import java.util.Collections;

/**
 * Create by: Jackson
 */
public class Question5 extends BaseQuestion{

    @Override
    public FunnyBean initFunnyBean() {
        FunnyBean funnyBean = new FunnyBean();
        funnyBean.setTitle("");
        funnyBean.setSuccessMsg("");
        funnyBean.setUse(true);
        funnyBean.addContent("please check your network");
        return funnyBean;
    }

    private FunnyQuestion question1() {
        FunnyQuestion funnyQuestion = new FunnyQuestion();
        funnyQuestion.setId("1");
        funnyQuestion.addAnswer("(O*&*(DKHJFKHJsdfw");
        funnyQuestion.setErrorChildId("1");
        funnyQuestion.setSuccessChildId("");
        return funnyQuestion;
    }

}
