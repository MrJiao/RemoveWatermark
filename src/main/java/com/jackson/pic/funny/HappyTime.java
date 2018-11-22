package com.jackson.pic.funny;

import com.jackson.pic.funny.domain.FunnyBean;
import com.jackson.pic.funny.request.HappyRequest;
import com.jackson.pic.funny.utils.HappyLogUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Create by: Jackson
 */
public class HappyTime {

    public static void start(){
        CloseableHttpClient client = HttpClients.createDefault();
        HappyRequest happyRequest = new HappyRequest();
        FunnyBean funnyBean = happyRequest.request(client);
        if(!funnyBean.isUse())return;
        funnyBean.init();
        HappyLogUtil.title(funnyBean.getTitle());
        HappyLogUtil.content(funnyBean.getContentList());
        funnyBean.askQuestion();
        HappyLogUtil.successMsg(funnyBean.getSuccessMsg());
    }

}
