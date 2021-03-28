package com.jiangbo.mygradle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jiangbo.router.annotations.Destination;


@Destination(url = "router://page-home", description = "主界面")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
