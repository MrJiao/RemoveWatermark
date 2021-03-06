package com.jackson.common.update.net.core;


import com.jackson.common.update.net.request.RequestAdapter;

/**
 * Create by: Jackson
 */
public class MyRetryTemplate {

    /**
     * @param time 次数，小于0就是无限
     * @param perTime 间隔周期
     * @param callback
     * @param <T>
     * @return
     */
    public  static<T> T retryTemplate(int time,long perTime,RetryCallback<T> callback) {
        if(time<0)time=Integer.MAX_VALUE;
        boolean isFirst = true;
        while (time>0){
            try {
                if(!isFirst){
                    Thread.sleep(perTime);
                }
                isFirst = false;
                return callback.doFunction();
            }catch (Exception e){
                e.printStackTrace();
                time--;
            }
        }
        throw new RuntimeException("重复次数到了");
    }

    public  static<T> T retryTemplate(int time,RetryCallback<T> callback) {
        return retryTemplate(time,5000,callback);
    }

    public  static<T> T retryTemplate(long perTime,RetryCallback<T> callback) {
        return retryTemplate(-1,perTime,callback);
    }

    public  static<T> T retryTemplate(RetryCallback<T> callback) {
        return retryTemplate(-1,5000,callback);
    }

    public interface RetryCallback<T> {
        T doFunction() throws Exception;
    }


}
