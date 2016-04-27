package cn.police.police.page;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.police.police.BaseActivity;
import cn.police.police.R;
/*2016-4-23*/


public class ArraignmentRoomStatusActivity extends BaseActivity {

    ViewPager pager;
    private List<Fragment> fragments;
    TextView starttime;
    TextView finishtime;

    String strbegaindate;//前一个activity传的值
    String strfinishtime;//前一个activity传的值


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_arraignment_room_status);
    }

    @Override
    public void initView() {
        setTvTitle("看守所提审室预定");
        Intent intent = getIntent();
        if(intent.getStringExtra("strbegaindate") != null){
            strbegaindate = intent.getStringExtra("strbegaindate");
        }
        if(intent.getStringExtra("strfinishtime") !=null){
            strfinishtime = intent.getStringExtra("strfinishtime");
        }
        starttime = (TextView) findViewById(R.id.starttime);
        starttime.setText(strbegaindate);
        finishtime = (TextView) findViewById(R.id.finishtime);
        finishtime.setText(strfinishtime);

        pager = (ViewPager) findViewById(R.id.project_pager);

        fragments=new ArrayList<>();
        fragments.add(ArraignedRoomFramgent.newInstance());

        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }
    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getCount() {
            return fragments.size();
        }

        public Fragment getItem(int position) {
            return fragments.get(position) ;
        }
    }

    /**提供启动该Activity的方法*/
    public static void startactivity(Context context,String begaintime,String finishtime){
        Intent intent = new Intent(context,ArraignmentRoomStatusActivity.class);
        intent.putExtra("strbegaindate",begaintime);
        intent.putExtra("strfinishtime",finishtime);
        context.startActivity(intent);
    }

}
