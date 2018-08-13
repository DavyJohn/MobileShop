package com.huatec.edu.mobileshop.server;

import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.TQData;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by NTVU on 2018/8/7.
 */

public class ApiWrapper extends HttpMethods {

//    public static void getData(Subscriber<TQData> sub){
//        Observable<TQData> observable = memberServer.getData()
//                .map(new HttpResultFunc<TQData>());
//        toSubseribe(observable,sub);
//    }
    //去掉map 转换
        public static void getData(String city,Subscriber<HttpResult<TQData>> sub){
            Observable<HttpResult<TQData>> observable = memberServer.getData(city);
            toSubseribe(observable,sub);
        }


}
