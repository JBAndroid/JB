package com.jiangbo.mygradle.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 项目名称：你今天真好看
 * 类描述：
 *
 * @auther jiangbo
 * 创建时间：2021-03-21
 */

public class HandlerActivity extends Activity {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }

        @Override
        public void dispatchMessage(@NonNull Message msg) {
            super.dispatchMessage(msg);
        }

        @NonNull
        @Override
        public String getMessageName(@NonNull Message message) {
            return super.getMessageName(message);
        }

        @Override
        public boolean sendMessageAtTime(@NonNull Message msg, long uptimeMillis) {
            return super.sendMessageAtTime(msg, uptimeMillis);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public void sendMessage() {
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, null, 1000);


        handler.postAtFrontOfQueue(new Runnable() {
            @Override
            public void run() {

            }
        });

        handler.postAtTime(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);


        handler.postAtTime(new Runnable() {
            @Override
            public void run() {

            }
        }, null, 1000);
    }
}
