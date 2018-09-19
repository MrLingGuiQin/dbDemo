package com.example.ling.renjingdemo.db;

import android.content.Context;
import org.greenrobot.greendao.database.Database;

/**
 * ***************************************
 * statement: 操作数据库的帮助类
 * author: LingGuiQin
 * date created : 2018-04-04
 * ***************************************
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper {

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {

    }
}
