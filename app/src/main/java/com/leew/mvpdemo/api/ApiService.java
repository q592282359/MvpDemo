package com.leew.mvpdemo.api;


import com.leew.mvpdemo.model.TestBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author :Leew
 * @date ：2018/8/10 on 10:48
 * Description:
 */
public interface ApiService {

    @GET("service/regeo?longitude=121.04925573429551&latitude=31.315590522490712")
    Observable<TestBean> test();
}
