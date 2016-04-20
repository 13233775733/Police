package cn.police.police;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;



import java.util.ArrayList;
import java.util.List;


import cn.police.police.page.PoliceFramgent;
import cn.police.police.page.PoliceFramgent2;
import cn.police.police.page.PoliceFramgent3;
import cn.police.police.utils.SizeUtil;

public class IndexActivity extends BaseActivity {
    PagerSlidingTabStrip tabs;
    ViewPager pager;
    private List<Fragment> fragments;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_index);
    }

    @Override
    public void initView() {

        setTvTitle("看守所提案室预定");

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabstrip);
        pager = (ViewPager) findViewById(R.id.project_pager);
        fragments=new ArrayList<>();
        fragments.add(PoliceFramgent.newInstance());
        fragments.add(PoliceFramgent2.newInstance());
        fragments.add(PoliceFramgent3.newInstance());
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setShouldExpand(true);
        tabs.setTextSize(SizeUtil.dip2px(IndexActivity.this, 14));
        tabs.setTabPaddingLeftRight(SizeUtil.dip2px(IndexActivity.this, 10));
        tabs.setDividerColorResource(R.color.translate);
        tabs.setIndicatorColorResource(R.color.text_showred);
        tabs.setIndicatorHeight(SizeUtil.dip2px(IndexActivity.this, 1));
        tabs.setUnderlineHeight(SizeUtil.dip2px(IndexActivity.this, 1));
        tabs.setTextColorResource(R.color.textshallow);
        tabs.setViewPager(pager);
        pager.setCurrentItem(0);
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "当前提审室状态", "按编号预定","按时间预定"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position) ;
        }
    }
}
