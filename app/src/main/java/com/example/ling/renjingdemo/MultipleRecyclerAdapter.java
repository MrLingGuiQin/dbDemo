package com.example.ling.renjingdemo;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ling.renjingdemo.db.StepRecord;

import java.util.List;

/**
 * ***************************************
 * statement:
 * author: lingguiqin
 * date created : 2017/10/28 0028
 * ***************************************
 */
public class MultipleRecyclerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public MultipleRecyclerAdapter(List<MultiItemEntity> data) {
        super(data);
        init();
    }


    private void init() {
        //设置不同的item布局
        addItemType(ItemType.TYPE_TIME, R.layout.item_date);
        addItemType(ItemType.TYPE_STEP, R.layout.item_step);
    }


    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        final int position = helper.getAdapterPosition();
        switch (helper.getItemViewType()) {
            case ItemType.TYPE_TIME:
                final RecordTime recordTime = (RecordTime) item;
                helper.setText(R.id.txt_date, recordTime.date);
                if (position == 0) {
                    helper.setTextColor(R.id.txt_date, Color.parseColor("#0aaeba"));
                } else {
                    helper.setTextColor(R.id.txt_date, Color.parseColor("#3d3d3d"));
                }
                break;

            case ItemType.TYPE_STEP:
                final StepRecord stepRecord = (StepRecord) item;
                helper.setText(R.id.txt_step_time, stepRecord.getTime());
                helper.setText(R.id.txt_step, stepRecord.getStepInfo());
                break;
        }
    }
}
