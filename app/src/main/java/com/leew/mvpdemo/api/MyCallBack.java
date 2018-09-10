package com.leew.mvpdemo.api;

import com.leew.mvpdemo.model.HttpExceptionBean;

/**
 * @author :Leew
 * @date ：2018/8/10 on 11:10
 * Description:
 */
public interface MyCallBack <T> {

    void onCompleted();

    void onError(HttpExceptionBean httpExceptionBean);

    void onNext(T t);
}
