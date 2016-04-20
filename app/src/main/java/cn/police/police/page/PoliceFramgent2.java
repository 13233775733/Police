package cn.police.police.page;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.police.police.R;


public class PoliceFramgent2 extends Fragment {

    public static PoliceFramgent2 newInstance() {
        PoliceFramgent2 fragment = new PoliceFramgent2();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_police_framgent2,container,false);
        return view;
    }

}
