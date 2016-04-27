package cn.police.police.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.police.police.BaseActivity;
import cn.police.police.R;

public class YuYueActivity extends BaseActivity {
    ViewPager pager;
    private List<Fragment> fragments;



    @Override
    public void setLayout() {
        setContentView(R.layout.activity_yu_yue);
    }

    @Override
    public void initView() {
        setTvTitle("看守所提审室预定");
        pager = (ViewPager) findViewById(R.id.project_pager);

        fragments=new ArrayList<>();
        fragments.add(YuYueFramgent.newInstance());

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
}
