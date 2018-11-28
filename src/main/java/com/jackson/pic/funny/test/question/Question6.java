package com.jackson.pic.funny.test.question;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;

/**
 * Create by: Jackson
 */
public class Question6 extends BaseQuestion{

    @Override
    public FunnyBean initFunnyBean() {
        FunnyBean funnyBean = new FunnyBean();
        funnyBean.setTitle("徐老师小课堂");
        funnyBean.addContent("请认真回答下面问题");
        funnyBean.setSuccessMsg("么么哒");
        funnyBean.setUse(true);
        return funnyBean;
    }


    private FunnyQuestion question1() {
        FunnyQuestion funnyQuestion = new FunnyQuestion();
        funnyQuestion.setId("1");
        funnyQuestion.addQuestion("有一座11米高且很滑的砖墙，一只蜗牛从墙底开始向上爬。一个小时它能爬5米，但是每爬完一个小时后它都要歇上一小时，在这一小时的休息过程中，它又滑下去3米。那么蜗牛爬到墙顶要几小时?？");
        funnyQuestion.addAnswer("知道");
        funnyQuestion.addAnswer("zhidao");
        funnyQuestion.addAnswer("yes");
        funnyQuestion.addAnswer("嗯");
        funnyQuestion.addAnswer("en");
        funnyQuestion.addAnswer("hao");
        funnyQuestion.addAnswer("好");
        funnyQuestion.addError("");
        funnyQuestion.setErrorChildId("1");
        return funnyQuestion;
    }


}
