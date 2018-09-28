package com.example.ling.renjingdemo.db;

import android.app.Activity;

import com.example.ling.renjingdemo.IGlobalCallback;

import org.greenrobot.greendao.query.CloseableListIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018/9/19 0019
 * ***************************************
 */
public class DBHelper {

    public static void insert(final StepRecord record) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseManager.getInstance().getStepRecordDao().insert(record);
            }
        }).start();
    }

    public static void insert(final List<StepRecord> records) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseManager.getInstance().getStepRecordDao().insertInTx(records);
            }
        }).start();
    }


    public static void queryRecord(final Activity activity, final IGlobalCallback<List<List<StepRecord>>> callback) {

        final List<List<StepRecord>> tempList = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final CloseableListIterator<StepRecord> iterator = DatabaseManager.getInstance()
                        .getStepRecordDao()
                        .queryBuilder()
                        .orderDesc(StepRecordDao.Properties.Time)
                        .listIterator();

                String tempDate = null;
                List<StepRecord> oneDayList = null;
                while (iterator.hasNext()) {
                    final StepRecord stepRecord = iterator.next().clone();
                    // 2018-08-10 8:00:12
                    final String nowDate = stepRecord.getTime().split(" ")[0];
                    if (tempDate == null) {
                        tempDate = nowDate;
                        oneDayList = new ArrayList<>();
                    }

                    if (nowDate.equals(tempDate)) {
                        oneDayList.add(stepRecord);
                    }

                    if (!nowDate.equals(tempDate)) {
                        tempList.add(oneDayList);
                        oneDayList = new ArrayList<>();
                        oneDayList.add(stepRecord);
                        tempDate = nowDate;
                    }
                }

                if (oneDayList != null && oneDayList.size() > 0) {
                    tempList.add(oneDayList);
                }

                try {
                    iterator.close();
                } catch (IOException e) {

                }
                if (callback != null) {
                    callback.executeCallback(tempList);
                }

                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.executeCallback(tempList);
                        }
                    }
                });
            }
        }).start();
    }
}
