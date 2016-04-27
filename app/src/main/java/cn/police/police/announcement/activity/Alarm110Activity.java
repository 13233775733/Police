package cn.police.police.announcement.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.police.police.R;
import cn.police.police.utils.RefreshableView;

/*2016/4/25,lhp*/

/**
 *110接处警Activity
 */
public class Alarm110Activity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout head_back;//返回
    private List<Map<String,String>> list;
    private Map<String,String> maplist;
    private Alarm110Adapter adapter;
    private RefreshableView refreshable_view;
    private ListView list_110alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm110);
        initview();
        setclick();
    }

    public void initview(){
        list = new ArrayList<>();
        for(int i=0;i<10;i++){
            maplist = new HashMap<>();
            maplist.put("casename","城南盗窃案0123456789有没有跑马灯的效果呀_"+i);
            maplist.put("casehand","薛岳_"+i+"\t||\t"+"综合勤务室_"+i);
            maplist.put("casedate","2016.04.20_"+i);
            maplist.put("casedescribe", "张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等张三盗窃刘寡妇家二个鸡蛋,一个番茄还有一根葱一个土豆等");
            list.add(i,maplist);
        }
        head_back = (LinearLayout) findViewById(R.id.head_back);
        refreshable_view = (RefreshableView) findViewById(R.id.refreshable_view);
        list_110alarm = (ListView) findViewById(R.id.list_110alarm);


        adapter = new Alarm110Adapter(this,list);
        list_110alarm.setAdapter(adapter);

        refreshable_view.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshable_view.finishRefreshing();
            }
        }, 0);


    }

    public void setclick(){
        head_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_back:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 110接处警界面列表的Adapter
     */
    public class Alarm110Adapter extends BaseAdapter{
        private Context context;
        private List<Map<String,String>> list;

        public Alarm110Adapter(Context context, List<Map<String, String>> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            int count = 0;
            if(list != null){
                count = list.size();
            }
            return count;
        }

        @Override
        public Map<String,String> getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.activity_alarm110_item,null);
                viewHolder.tv_casename = (TextView) convertView.findViewById(R.id.tv_casename);//案件名称
                viewHolder.tv_casehandandpartment = (TextView) convertView.findViewById(R.id.tv_casehandandpartment);//案件处理人
                viewHolder.tv_casedate = (TextView) convertView.findViewById(R.id.tv_casedate);//案件日期
                viewHolder.tv_casedescribe = (TextView) convertView.findViewById(R.id.tv_casedescribe);//案件描述
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
//str.substring(0, str.length()>30?30str.length())+"......"
            viewHolder.tv_casename.setText(list.get(position).get("casename"));
            viewHolder.tv_casehandandpartment.setText(list.get(position).get("casehand"));
            viewHolder.tv_casedate.setText(list.get(position).get("casedate"));

//            String strdescribe = list.get(position).get("casedescribe");
//            String s = list.get(position).get("casedescribe").substring(0, list.get(position).get("casedescribe").length() > 80 ? 80 : list.get(position).get("casedescribe").length());
            viewHolder.tv_casedescribe.setText(list.get(position).get("casedescribe").substring(0, list.get(position).get("casedescribe").length() > 80 ? 80 : list.get(position).get("casedescribe").length())+"……");
//            viewHolder.tv_casedescribe.setText(list.get(position).get("casedescribe"));

            return convertView;
        }


        public class ViewHolder{
            private TextView tv_casename;
            private TextView tv_casehandandpartment;
            private TextView tv_casedate;
            private TextView tv_casedescribe;
        }
    }

}

