package com.jackson.pic.funny.test.question;
import com.jackson.pic.Config;
import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;
/**
 * Create by: Jackson
 */
public class Question6 extends BaseQuestion{
    @Override
    public FunnyBean initFunnyBean() {
        FunnyBean funnyBean = new FunnyBean();
        funnyBean.setTitle("软件有更新 2018-11-30 版本:"+ Config.version);
        funnyBean.addContent("百度网盘下载地址: https://pan.baidu.com/s/1bYWZRnkquvhC3l2I9bQK0A");
        funnyBean.addContent("密码:tv4e");
        funnyBean.addContent("已经更新请忽略");
        funnyBean.addContent("输入任意字符按回车继续使用");
        funnyBean.setSuccessMsg("");
        funnyBean.setUse(true);
        return funnyBean;
    }

    private FunnyQuestion question1() {
        FunnyQuestion funnyQuestion = new FunnyQuestion();
        funnyQuestion.setId("1");
        funnyQuestion.addAnswer(FunnyQuestion.allRight);
        return funnyQuestion;
    }


}
