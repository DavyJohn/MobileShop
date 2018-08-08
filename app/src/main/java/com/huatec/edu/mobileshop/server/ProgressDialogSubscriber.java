package com.huatec.edu.mobileshop.server;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public abstract class ProgressDialogSubscriber<T> extends Subscriber<T> {
    private Context context;
    private ProgressDialog mDialog;
    public ProgressDialogSubscriber(Context context){
        this.context = context;
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException){
            Toast.makeText(context,"网络中断，请检查您的网络状况",Toast.LENGTH_LONG).show();
        }else if (e instanceof ConnectException){
            Toast.makeText(context,"网络中断，请检查您的网络状况",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"error:"+e.getMessage(),Toast.LENGTH_LONG).show();
            System.out.print("error:"+e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onStart() {
        super.onStart();
        showProgressDialog();
    }
    private void showProgressDialog(){
        if (mDialog == null){
            mDialog = new ProgressDialog(context);
            mDialog.setCancelable(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    ProgressDialogSubscriber.this.unsubscribe();//取消订阅，取消请求
                }
            });
        }
        if (mDialog != null && !mDialog.isShowing()){
            mDialog.show();
        }
    }
    private void dismissProgressDialog(){
        if (mDialog != null&& mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }
    }

}
