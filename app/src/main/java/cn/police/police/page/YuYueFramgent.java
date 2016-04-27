package cn.police.police.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.police.police.R;


public class YuYueFramgent extends Fragment {

    private static ListView li;
    @InjectView(R.id.listView)
    PullToRefreshListView listView;
    private YuYueAdapter adapter;
    private int page;

    private List<String[]> list;


    public static YuYueFramgent newInstance() {
        YuYueFramgent fragment = new YuYueFramgent();




        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_list_view, container, false);
        ButterKnife.inject(this, view);
        initView();

        return view;
    }

    private void initView() {
        list=new ArrayList<>();
        list.add(new String[]{"11111", "可预约", "true"});
        list.add(new String[]{"22222", "不可预约", "false"});

        adapter=new YuYueAdapter(getActivity(),list);
        listView.setAdapter(adapter);

        listView.setScrollingWhileRefreshingEnabled(!listView.isScrollingWhileRefreshingEnabled());

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
            }
        });


        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.onRefreshComplete();
            }
        }, 1000);


    }

}
