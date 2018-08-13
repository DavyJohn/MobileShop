package com.huatec.edu.mobileshop.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.activity.MainActivity;
import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.TQData;
import com.huatec.edu.mobileshop.server.ApiWrapper;
import com.huatec.edu.mobileshop.server.HttpMethods;
import com.huatec.edu.mobileshop.server.MemberServer;
import com.huatec.edu.mobileshop.server.ProgressDialogSubscriber;

import java.io.IOException;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.SafeSubscriber;
import rx.schedulers.Schedulers;

public class HomeFragment extends BaseFragment {

    private TextView mText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mText = (TextView) view.findViewById(R.id.sy_text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.sojson.com/open/api/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MemberServer server = retrofit.create(MemberServer.class);
        final Call<HttpResult<TQData>> call = server.getTQ("北京");
        //异步
      /*  call.enqueue(new Callback<HttpResult<TQData>>() {
            @Override
            public void onResponse(Call<HttpResult<TQData>> call, Response<HttpResult<TQData>> response) {
                String data = response.body().getData().getGanmao();
                System.out.print(data);
            }

            @Override
            public void onFailure(Call<HttpResult<TQData>> call, Throwable t) {

            }
        });*/
        //同步 //需要开启线程 否者容易阻塞 主线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<HttpResult<TQData>>  response = call.execute();
                    String data = response.body().getData().getGanmao();
                    System.out.print(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //异步+Retrofit+RxJava
     /*   ApiWrapper.getData("北京",new ProgressDialogSubscriber<HttpResult<TQData>>(getActivity()){
            @Override
            public void onNext(HttpResult<TQData> tqData) {
                System.out.print(tqData);
                mText.setText(tqData.getData().getForecast().get(2).getDate());
            }
        });*/


    }
}
