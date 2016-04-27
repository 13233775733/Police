package cn.police.police.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.police.police.R;
import cn.police.police.adapter.NumTableListViewAdapter;
import cn.police.police.adapter.TableListViewAdapter;


public class PoliceFramgent2 extends Fragment {

//    private static final String[] m={"1","2","3","4","5","6","7","8","其他"};

    private ArrayAdapter<String> adapter;

    private List<List<String>> list = new ArrayList<>();

    @InjectView(R.id.spinner1)
    Spinner spinner1;

    @InjectView(R.id.spinner2)
    Spinner spinner2;

    @InjectView(R.id.spinner3)
    Spinner spinner3;

    @InjectView(R.id.spinner4)
    Spinner spinner4;

    @InjectView(R.id.tv_weeknum)
    TextView tv_weeknum;
    private NumTableListViewAdapter adapter2;

    public static PoliceFramgent2 newInstance() {
        PoliceFramgent2 fragment = new PoliceFramgent2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 10; i++) {
            List<String> str_list = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                str_list.add("预约" + String.valueOf(i) + String.valueOf(j));
            }
            list.add(str_list);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_police_framgent2, container, false);
        ButterKnife.inject(this, view);

        ListView listview = (ListView) view.findViewById(R.id.numtable_listview);
        listview.setAdapter(new NumTableListViewAdapter(this.getActivity(),list));

        View listItem = new NumTableListViewAdapter(this.getActivity(),list).getView(0, null, listview);
        listItem.measure(0, 0);
        listview.getLayoutParams().height = (listItem.getMeasuredHeight()+listview.getDividerHeight()) * 6;


//        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,m);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(adapter);
//        spinner1.setVisibility(View.VISIBLE);



        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv_weeknum.setText(getActivity().getResources().getStringArray(R.array.policefrg2_week)[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return view;
    }





}
