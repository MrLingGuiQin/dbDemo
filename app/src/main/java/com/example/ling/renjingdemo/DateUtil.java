package com.example.ling.renjingdemo;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ***************************************
 * statement:
 * author: LingGuiQin
 * date created : 2018-04-03
 * ***************************************
 */
public class DateUtil {

    /**
     * 取出时间
     * 2018-01-01 12:00:00  ---> 12:00:00
     *
     * @param time 2018-01-01 12:00:00
     * @return 12:00:00
     */
    public static String getTimeString(String time) {
        if (!TextUtils.isEmpty(time)
                && time.contains(" ")) {
            return time.split(" ")[1];
        }
        return "";
    }

    /**
     * 获取当天的时间日期  2018-08-08 08:12:00
     *
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getDateString() {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = format.format(new Date());
        return time;
    }

}
