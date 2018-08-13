package com.huatec.edu.mobileshop.server;

import android.database.Observable;
import android.icu.util.TimeUnit;
import android.util.Log;

import com.huatec.edu.mobileshop.entity.HttpResult;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by NTVU on 2018/8/7.
 */

public class HttpMethods {
    protected static final String BASE_URL ="https://www.sojson.com/open/api/weather/";
    private static final int DEFAULT_TIMEOUT = 5;
    protected static final String TAG = "HttpMethods";
    private Retrofit retrofit;
    private static HttpMethods methods;
    protected static MemberServer memberServer;

    public HttpMethods(){
        if (methods == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    //打印retrofit日志
                    Log.i("RetrofitLog","retrofitBack = "+message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)

                    .addInterceptor(loggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            memberServer = retrofit.create(MemberServer.class);
        }
    }

    public static HttpMethods getInstance(){
        if(methods == null){
            synchronized (HttpMethods.class){
                if (methods == null){
                    methods = new HttpMethods();
                }
            }
        }
        return methods;
    }
    //分割数据 返回T数据
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>,T>{
        @Override
        public T call(HttpResult<T> tHttpResult) {
            return tHttpResult.getData();
        }
    }

    public static <T> void toSubseribe(rx.Observable<T> observable, Subscriber<T> subscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }
}
