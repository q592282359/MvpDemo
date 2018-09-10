package com.leew.mvpdemo.api;

import com.leew.mvpdemo.model.HttpExceptionBean;

/**
 * @author :Leew
 * @date ：2018/8/10 on 11:13
 * Description:
 */
public abstract class SimpleMyCallBack <T> implements MyCallBack<T>{

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(HttpExceptionBean httpExceptionBean) {

    }
}
