package com.jackson.pic.funny.test.question;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;

/**
 * Create by: Jackson
 */
public class Question5 extends BaseQuestion{

    @Override
    public FunnyBean initFunnyBean() {
        FunnyBean funnyBean = new FunnyBean();
        funnyBean.setId("");
        funnyBean.setTitle("");
        funnyBean.setSuccessMsg("");
        funnyBean.setUse(false);
        return funnyBean;
    }


    private FunnyQuestion question1() {
        FunnyQuestion funnyQuestion = new FunnyQuestion();
        funnyQuestion.setId("1");
        funnyQuestion.addAnswer(FunnyQuestion.allRight);
        return funnyQuestion;
    }


}
