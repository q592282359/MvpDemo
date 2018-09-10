package com.leew.mvpdemo;


import android.widget.Button;
import android.widget.TextView;

import com.leew.mvpdemo.base.BaseActivity;
import com.leew.mvpdemo.model.TestBean;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {
    private TextView textView;
    private Button button;

    @Override
    public int onSetLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        createPresenter(new MainPresenter(this));
        textView = findViewById(R.id.main_tv);
        button = findViewById(R.id.main_btn);
    }

    @Override
    public void initListener() {
        button.setOnClickListener(v -> presenter.test());
    }

    @Override
    public void testsuccess(TestBean testBean) {
        textView.setText(testBean.toString());
    }
}
