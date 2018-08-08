package com.huatec.edu.mobileshop.server;


import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.TQData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NTVU on 2018/8/7.
 */

public interface MemberServer {

    @GET("json.shtml?city=北京")
    rx.Observable<HttpResult<TQData>> getData();
}
