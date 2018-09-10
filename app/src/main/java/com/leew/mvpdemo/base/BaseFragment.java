package com.leew.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leew.mvpdemo.api.ApiWrapper;

import rx.subscriptions.CompositeSubscription;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:29
 * Description:
 */
public abstract class BaseFragment <T extends BasePresenter> extends Fragment{

    public BaseActivity context;

    public CompositeSubscription compositeSubscription;

    public ApiWrapper apiWrapper;

    public  T presenter;


    public abstract int onSetLayoutId();

    public abstract  void initView();

    public abstract  void initListener();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(onSetLayoutId(),container,false);

    }

    public void createPresenter(T presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }
}
