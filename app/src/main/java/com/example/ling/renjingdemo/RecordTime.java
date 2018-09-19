package com.example.ling.renjingdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/9/18 0018
 * ***************************************
 */
public class RecordTime implements MultiItemEntity {
    public String date;

    public RecordTime(String date) {
        this.date = date;
    }

    @Override
    public int getItemType() {
        return ItemType.TYPE_TIME;
    }
}
