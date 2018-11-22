package com.jackson.pic.funny.test.question;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.domain.FunnyQuestion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Create by: Jackson
 */
public abstract class BaseQuestion {

    abstract FunnyBean initFunnyBean();

    public FunnyBean get(){
        FunnyBean funnyBean = initFunnyBean();
        ArrayList<Method> methodArr = new ArrayList<>();

        Method[] methods = getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().contains("question")&&method.getParameterCount()==0){
                method.setAccessible(true);
                methodArr.add(method);
            }
        }
        for (Method method : methodArr) {
            try {
                FunnyQuestion question = (FunnyQuestion) method.invoke(this);
                funnyBean.addQuestion(question);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return funnyBean;
    }

}
