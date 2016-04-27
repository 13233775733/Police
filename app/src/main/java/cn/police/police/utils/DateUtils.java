package cn.police.police.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** Created by lhp on 2016/4/27 */

/**
 * 处理时间的工具类
 */
public class DateUtils {

    private static SimpleDateFormat sdf = null;

    /**获取系统时间 格式为："yyyy/MM/dd"*/
    public static String getCurrentDate() {
        Date d = new Date();
        sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        return sdf.format(d);
    }

    /**将时间戳转换成字符窜格式*/
    public static String getTimestampsToString(long time) {
        Date d = new Date(time);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
        return sdf.format(d);
    }

    /**将时间字符串转为时间戳*/
    public static long getStringToTimestamps (String time) {
        sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
