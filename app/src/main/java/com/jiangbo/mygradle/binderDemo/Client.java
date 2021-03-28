package com.jiangbo.mygradle.binderDemo;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import java.io.FileDescriptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 项目名称：你今天真好看
 * 类描述：
 *
 * @auther jiangbo
 * 创建时间：2021-03-26
 */
public class Client implements IBinder {
    @Nullable
    @Override
    public String getInterfaceDescriptor() throws RemoteException {
        return null;
    }

    @Override
    public boolean pingBinder() {
        return false;
    }

    @Override
    public boolean isBinderAlive() {
        return false;
    }

    @Nullable
    @Override
    public IInterface queryLocalInterface(@NonNull String descriptor) {
        return null;
    }

    @Override
    public void dump(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

    }

    @Override
    public void dumpAsync(@NonNull FileDescriptor fd, @Nullable String[] args) throws RemoteException {

    }

    @Override
    public boolean transact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        return false;
    }

    @Override
    public void linkToDeath(@NonNull DeathRecipient recipient, int flags) throws RemoteException {

    }

    @Override
    public boolean unlinkToDeath(@NonNull DeathRecipient recipient, int flags) {
        return false;
    }
}
