package com.leew.mvpdemo;

import com.leew.mvpdemo.base.BaseCommonPresenter;
import com.leew.mvpdemo.base.BasePresenter;
import com.leew.mvpdemo.base.BaseView;
import com.leew.mvpdemo.model.TestBean;

/**
 * @author :Leew
 * @date ：2018/8/10 on 11:39
 * Description:
 */
public interface MainContract {
    interface View extends BaseView {
        void testsuccess(TestBean testBean);
    }

    interface Presenter extends BaseCommonPresenter {
        void test();
    }
}
