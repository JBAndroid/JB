package com.jiangbo.mygradle.broadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.jiangbo.mygradle.BaseActivity;

import androidx.annotation.Nullable;

/**
 * 项目名称：你今天真好看
 * 类描述：
 *
 * @auther jiangbo
 * 创建时间：2021-03-28
 */
public class BroadCastActivity extends BaseActivity {
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        receiver = new MyReceiver();

        registerReceiver(receiver, new IntentFilter());
        Intent intent = new Intent(this, MyReceiver.class);
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public static class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }


}
