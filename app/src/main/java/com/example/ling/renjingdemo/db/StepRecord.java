package com.example.ling.renjingdemo.db;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ling.renjingdemo.ItemType;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/9/18 0018
 * ***************************************
 */

// nameInDb 定义表名 不定义默认是当前类名
@Entity(nameInDb = "step_records")
public class StepRecord implements MultiItemEntity,Cloneable {

    @Id(autoincrement = true)
    private Long recordId;
    private String time;
    private String stepInfo;


    @Generated(hash = 41842969)
    public StepRecord(Long recordId, String time, String stepInfo) {
        this.recordId = recordId;
        this.time = time;
        this.stepInfo = stepInfo;
    }

    @Generated(hash = 830414990)
    public StepRecord() {
    }

    public Long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStepInfo() {
        return this.stepInfo;
    }

    public void setStepInfo(String stepInfo) {
        this.stepInfo = stepInfo;
    }

    @Override
    public int getItemType() {
        return ItemType.TYPE_STEP;
    }

    @Override
    public StepRecord clone() {
        StepRecord records = null;
        try {
            records = (StepRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return records;
    }
}
