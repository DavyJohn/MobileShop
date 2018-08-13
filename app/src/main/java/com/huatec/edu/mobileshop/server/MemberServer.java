package com.huatec.edu.mobileshop.server;


import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.TQData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NTVU on 2018/8/7.
 */

public interface MemberServer {

    @GET("json.shtml")
    rx.Observable<HttpResult<TQData>> getData(@Query("city") String city);
    //不是用观察者
    @GET("json.shtml")
    Call<HttpResult<TQData>> getTQ(@Query("city") String city);

}
