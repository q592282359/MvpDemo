package com.leew.mvpdemo.base;

import android.widget.Toast;

import com.google.gson.Gson;
import com.leew.mvpdemo.api.Api;
import com.leew.mvpdemo.api.ApiWrapper;
import com.leew.mvpdemo.api.SimpleMyCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:29
 * Description:
 */
public class BasePresenter <T extends BaseView >{

    protected ApiWrapper mApiWrapper;

    protected CompositeSubscription mCompositeSubscription;

    public T view;

    public BasePresenter(T view){
        mCompositeSubscription = new CompositeSubscription();
        mApiWrapper = new ApiWrapper();
        this.view = view;
    }


    protected <E> Subscriber newMySubscriber(final SimpleMyCallBack onNext) {
        return new Subscriber<E>() {
            @Override
            public void onCompleted() {
                onNext.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof Api.APIException) {
                    Api.APIException exception = (Api.APIException) e;
                } else if (e instanceof HttpException) {
                    if (e instanceof HttpException) {
                        ResponseBody body = ((HttpException) e).response().errorBody();
                        try {
                            String json = body.string();
                            Toast.makeText(App.getInstance().getApplicationContext(),json,Toast.LENGTH_SHORT).show();
                        } catch (IOException IOe) {
                            IOe.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onNext(E t) {
                if (!mCompositeSubscription.isUnsubscribed()) {
                    onNext.onNext(t);
                }
            }
        };
    }
    public void unsubscribe() {
        if(mCompositeSubscription != null){
            mCompositeSubscription.unsubscribe();
        }
    }
}
