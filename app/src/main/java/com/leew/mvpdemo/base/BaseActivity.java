package com.leew.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leew.mvpdemo.api.Api;
import com.leew.mvpdemo.api.ApiWrapper;
import com.leew.mvpdemo.api.SimpleMyCallBack;

import retrofit2.HttpException;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:29
 * Description:
 */
public abstract class BaseActivity <T extends BaseCommonPresenter> extends AppCompatActivity {
    protected Activity Context;
    protected CompositeSubscription compositeSubscription;
    protected ApiWrapper apiWrapper;
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onSetLayoutId());
        initView();
        initListener();
    }

    public abstract int onSetLayoutId();

    public abstract void initView();

    public abstract  void initListener();

    public void createPresenter(T presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    public void initApi() {
        compositeSubscription = new CompositeSubscription();
        apiWrapper = new ApiWrapper();
    }

    public ApiWrapper getApiWrapper() {
        if (apiWrapper == null) {
            apiWrapper = new ApiWrapper();
        }
        return apiWrapper;
    }

    public CompositeSubscription getCompositeSubscription() {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        return compositeSubscription;
    }

    protected <T> Subscriber newMySubscriber(final SimpleMyCallBack onNext) {
        return new Subscriber<T>() {
            @Override
            public void onCompleted() {
                onNext.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof Api.APIException) {
                    Api.APIException exception = (Api.APIException) e;
                } else if (e instanceof HttpException) {
                }
            }
            @Override
            public void onNext(T t) {
                if (!compositeSubscription.isUnsubscribed()) {
                    onNext.onNext(t);
                }
            }

        };
    }

}
