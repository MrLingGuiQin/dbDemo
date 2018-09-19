package com.example.ling.renjingdemo;

import android.support.annotation.Nullable;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2017/12/10 0010
 * ***************************************
 */
public interface IGlobalCallback<T> {
    void executeCallback(@Nullable T args);
}
