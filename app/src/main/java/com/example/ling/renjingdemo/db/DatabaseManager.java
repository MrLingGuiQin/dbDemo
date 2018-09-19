package com.example.ling.renjingdemo.db;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * ***************************************
 * statement: 数据库操作管理类
 * author: LingGuiQin
 * date created : 2018-04-04
 * ***************************************
 */
public class DatabaseManager {

    private final String DB_NAME = "sky.db";

    private StepRecordDao mStepRecordDao;
    private DaoSession mDaoSession;

    public DatabaseManager() {
    }


    public static final class Holder {
        public static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }


    public DatabaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, DB_NAME);
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mStepRecordDao = mDaoSession.getStepRecordDao();
    }


    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public StepRecordDao getStepRecordDao() {
        return mStepRecordDao;
    }

}
