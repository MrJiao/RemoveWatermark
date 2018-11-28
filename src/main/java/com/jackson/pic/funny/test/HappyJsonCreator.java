package com.jackson.pic.funny.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.pic.utils.L;
import com.jackson.pic.funny.domain.FunnyBean;

/**
 * Create by: Jackson
 */
public class HappyJsonCreator {



    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper= new ObjectMapper();
        FunnyBean funnyBean = new ChooseQuestion().question;
        funnyBean.setUse(true);
        String s = mapper.writeValueAsString(funnyBean);
        L.d(s);
    }






}
