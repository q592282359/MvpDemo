package com.leew.mvpdemo.api;

import com.leew.mvpdemo.model.TestBean;

import rx.Observable;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:48
 * Description:
 */
public class ApiWrapper extends Api{


    public Observable<TestBean> test(){
        return applySchedulers(getService().test());
    }

}
