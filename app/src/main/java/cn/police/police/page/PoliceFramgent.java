package cn.police.police.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.police.police.R;
import cn.police.police.vhtable.HListViewActivity;


public class PoliceFramgent extends Fragment {

    public static PoliceFramgent newInstance() {
        PoliceFramgent fragment = new PoliceFramgent();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.fragment_police_framgent, container, false);
        return view;
    }

    private void initView() {


    }

}
