package com.example.ling.renjingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.ling.renjingdemo.db.DBHelper;
import com.example.ling.renjingdemo.db.DatabaseManager;
import com.example.ling.renjingdemo.db.StepRecord;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MultiItemEntity> mAdapterList = new ArrayList<>();
    private MultipleRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MultipleRecyclerAdapter(mAdapterList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        queryData();
    }

    private void queryData() {
        DBHelper.queryRecord(this, new IGlobalCallback<List<List<StepRecord>>>() {
            @Override
            public void executeCallback(@Nullable List<List<StepRecord>> lists) {
                mAdapterList.clear();
                for (List<StepRecord> records : lists) {
                    // 2018-08-12 08:00:00 ---> 2018-08-12
                    final String date = DateUtil.getTimeString(records.get(0).getTime());
                    mAdapterList.add(new RecordTime(date));
                    mAdapterList.addAll(records);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    public void addClick(View view) {

        // 创建需要插入的数据
        StepRecord stepRecord1 = new StepRecord(null, "2018-08-12 08:00:00", "止血操作");
        StepRecord stepRecord2 = new StepRecord(null, "2018-08-12 10:00:02", "包扎操作");
        StepRecord stepRecord3 = new StepRecord(null, "2018-08-12 09:12:00", "按压操作");

        StepRecord stepRecord4 = new StepRecord(null, "2018-08-10 10:00:00", "止血操作2");
        StepRecord stepRecord5 = new StepRecord(null, "2018-08-10 13:00:00", "止血操作4");
        StepRecord stepRecord6 = new StepRecord(null, "2018-08-10 08:00:00", "止血操作1");
        StepRecord stepRecord7 = new StepRecord(null, "2018-08-10 12:00:00", "止血操作3");

        StepRecord stepRecord8 = new StepRecord(null, "2018-08-08 18:00:00", "其他操作6");
        StepRecord stepRecord9 = new StepRecord(null, "2018-08-08 14:00:00", "其他操作4");
        StepRecord stepRecord10 = new StepRecord(null, "2018-08-08 17:00:00", "其他操作5");
        StepRecord stepRecord11 = new StepRecord(null, "2018-08-08 11:00:00", "其他操作3");
        StepRecord stepRecord12 = new StepRecord(null, "2018-08-08 08:00:00", "其他操作1");
        StepRecord stepRecord13 = new StepRecord(null, "2018-08-08 10:00:00", "其他操作2");

        // 插入数据到数据库
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord1);
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord2);
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord3);
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord4);
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord5);
//        DatabaseManager.getInstance().getStepRecordDao().insert(stepRecord6);

//        DBHelper.insert(stepRecord1);
//        DBHelper.insert(stepRecord2);
//        DBHelper.insert(stepRecord3);
//
//        DBHelper.insert(stepRecord8);
//        DBHelper.insert(stepRecord9);
//        DBHelper.insert(stepRecord10);
//        DBHelper.insert(stepRecord11);
//        DBHelper.insert(stepRecord12);
//        DBHelper.insert(stepRecord13);
//
//        DBHelper.insert(stepRecord4);
//        DBHelper.insert(stepRecord5);
//        DBHelper.insert(stepRecord6);
//        DBHelper.insert(stepRecord7);

        List<StepRecord> stepRecords = new ArrayList<>();
        stepRecords.add(stepRecord1);
        stepRecords.add(stepRecord2);
        stepRecords.add(stepRecord3);
        stepRecords.add(stepRecord8);
        stepRecords.add(stepRecord9);
        stepRecords.add(stepRecord10);
        stepRecords.add(stepRecord11);
        stepRecords.add(stepRecord12);
        stepRecords.add(stepRecord13);

        stepRecords.add(stepRecord4);
        stepRecords.add(stepRecord5);
        stepRecords.add(stepRecord6);
        stepRecords.add(stepRecord7);

        DBHelper.insert(stepRecords);

        Toast.makeText(this, "插入数据成功", Toast.LENGTH_SHORT).show();
        queryData();
    }

    public void deleteClick(View view) {
        DatabaseManager.getInstance().getStepRecordDao().deleteAll();
        Toast.makeText(this, "删除全部数据成功", Toast.LENGTH_SHORT).show();
        queryData();
    }
}
