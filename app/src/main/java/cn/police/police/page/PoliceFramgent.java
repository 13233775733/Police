package cn.police.police.page;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.police.police.R;
import cn.police.police.adapter.TableListViewAdapter;


public class PoliceFramgent extends Fragment {

    public static PoliceFramgent newInstance() {
        PoliceFramgent fragment = new PoliceFramgent();
        return fragment;
    }

    private static final String[] m={"1","2","3","4","其他"};
    @InjectView(R.id.spinner1)
    Spinner spinner1;
    private ArrayAdapter<String> adapter;
    private TableListViewAdapter adapter2;

    private List<List<String>> list = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 0; i < 10; i++){
            List<String> str_list = new ArrayList<>();
            for(int j = 0; j < 7; j++){
                str_list.add("预约"+String.valueOf(i)+String.valueOf(j));
            }

            list.add(str_list);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.fragment_police_framgent, container, false);
        ButterKnife.inject(this,view);

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,m);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setVisibility(View.VISIBLE);
        ListView lsitview = (ListView) view.findViewById(R.id.table_listview);

        adapter2 = new TableListViewAdapter(this.getActivity(),list);

        lsitview.setAdapter(adapter2);
        return view;
    }

}
