package cn.police.police.page;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.police.police.R;

/**
 * 看守所提案室预定——按时间预定界面:l
 */

public class PoliceFramgent3 extends Fragment {
    private String date_str;//选择的日期
    private String time_str;//选择的时间

    private TextView frg3_begaindate;//选择的开始时间的:年月日
    private TextView frg3_begainA_P;//选择的开始时间的:上午或下午
    private TextView frg3_begaintime;//选择的开始时间的:时分秒

    private TextView frg3_finishdate;//选择的结束时间的:年月日
    private TextView frg3_finishA_P;//选择的结束时间的:上午或下午
    private TextView frg3_finishtime;//选择的结束时间的:时分秒


    public static PoliceFramgent3 newInstance() {
        PoliceFramgent3 fragment = new PoliceFramgent3();
      return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_police_framgent3,container,false);

        frg3_begaindate = (TextView) view.findViewById(R.id.frg3_begaindate);
        frg3_begainA_P = (TextView) view.findViewById(R.id.frg3_begainA_P);
        frg3_begaintime = (TextView) view.findViewById(R.id.frg3_begaintime);
        frg3_finishdate = (TextView) view.findViewById(R.id.frg3_finishdate);
        frg3_finishA_P = (TextView) view.findViewById(R.id.frg3_finishA_P);
        frg3_finishtime = (TextView) view.findViewById(R.id.frg3_finishtime);

        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.btn_ok)
    public void btn_ok(){
        String begaintimestr = frg3_begaindate.getText().toString().trim() + frg3_begainA_P.getText().toString().trim() + frg3_begaintime.getText().toString().trim();
        String finishtimestr = frg3_finishdate.getText().toString().trim() + frg3_finishA_P.getText().toString().trim() + frg3_finishtime.getText().toString().trim();
        ArraignmentRoomStatusActivity.startactivity(this.getActivity(),begaintimestr,finishtimestr);
    }

    @OnClick(R.id.btn_time)
    public void btn_time(){
        showDialog(1);


    }
    @OnClick(R.id.btn_time2)
    public void btn_time2(){
        showDialog(2);
    }

    public void showDialog(final int i) {
        DateTimePickerDialog dialog  = new DateTimePickerDialog(getActivity(), System.currentTimeMillis());

        dialog.setOnDateTimeSetListener(new DateTimePickerDialog.OnDateTimeSetListener() {
            public void OnDateTimeSet(AlertDialog dialog, long date) {
                Toast.makeText(getActivity(), "您输入的日期是：" + getStringDate(date) + getStringTime(date), Toast.LENGTH_LONG).show();
                if(i == 1){
                    frg3_begaindate.setText(getStringDate(date));
                    if(Integer.parseInt(getStringhh(date)) < 12){
                        frg3_begainA_P.setText("上午");
                    }else if(Integer.parseInt(getStringhh(date)) == 12 && Integer.parseInt(getStringmm(date)) < 1){
                        frg3_begainA_P.setText("上午");
                    }else {
                        frg3_begainA_P.setText("下午");
                    }
                    frg3_begaintime.setText(getStringTime(date));
                }if(i == 2){
                    frg3_finishdate.setText(getStringDate(date));
                    if(Integer.parseInt(getStringhh(date)) < 12){
                        frg3_finishA_P.setText("上午");
                    }else if(Integer.parseInt(getStringhh(date)) == 12 && Integer.parseInt(getStringmm(date)) < 1){
                        frg3_finishA_P.setText("上午");
                    }else {
                        frg3_finishA_P.setText("下午");
                    }
                    frg3_finishtime.setText(getStringTime(date));
                }

            }
        });
        dialog.show();
    }
    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     */
    public static String getStringDate(Long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
        return formatter.format(date);
    }

    public static String getStringTime(Long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm",Locale.CHINA);
        return formatter.format(date);
    }

    public static String getStringhh(Long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH", Locale.CHINA);
        return formatter.format(date);
    }

    public static String getStringmm(Long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm",Locale.CHINA);
        return formatter.format(date);
    }

}
