package cn.police.police.utils;

/**
 * Created by lhp on 2016/4/27.
 */
public class URLStringUtil {

    /**通知公告的接口地址*/
    private static final String NOTICE_BASEURL = "http://123.57.27.230:8088/infoIssue/android/inform/showFineTypeList";
//    public static final String BASE_URLHTTP = "http://";
//    public static String BASE_URLIP = "123.57.27.230:8088";
//    public static final String BASE_URLPATH = "/infoIssue/android/inform/showFineTypeList";



//    public static String BASE_URLIP() {
//        return BASE_URLIP;
//    }
//    public static void setBASE_URLIP(String BASE_URLIP) {
//        BASE_URLIP = BASE_URLIP;
//    }

    /**提供获取‘通知公告’地址的方法*/
    public static String getnoticeBaseUrl() {
//        return BASE_URLHTTP + BASE_URLIP + BASE_URLPATH;
        return NOTICE_BASEURL;
    }
}
