package com.leew.mvpdemo;

import com.leew.mvpdemo.api.Api;
import com.leew.mvpdemo.api.SimpleMyCallBack;
import com.leew.mvpdemo.base.BasePresenter;
import com.leew.mvpdemo.model.HttpExceptionBean;
import com.leew.mvpdemo.model.TestBean;

import rx.Subscription;

/**
 * @author :Leew
 * @date ：2018/8/10 on 11:39
 * Description:
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void test() {
        Subscription subscription = mApiWrapper.test()
                .subscribe(newMySubscriber(new SimpleMyCallBack<TestBean>() {
                                               @Override
                                               public void onNext(TestBean testBean) {
                                                   view.testsuccess(testBean);
                                               }

                                               @Override
                                               public void onError(HttpExceptionBean httpExceptionBean) {
                                                   super.onError(httpExceptionBean);
                                               }
                                           }
                ));
    }
}
