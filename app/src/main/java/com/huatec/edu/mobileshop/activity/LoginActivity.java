package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huatec.edu.mobileshop.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
    }
    public void register(View view){
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
    public void toMainActivity(View view){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
