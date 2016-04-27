package cn.police.police.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import cn.police.police.R;
import cn.police.police.page.ArraignmentRoomStatusActivity;
import cn.police.police.page.YuYueActivity;
/*2016/4/21 ,lhp*/

public class TableListViewAdapter extends BaseAdapter {
    private Context context;
    private List<List<String>> list;

    private int[] id;


    public TableListViewAdapter(Context context ,List<List<String>> list) {
        this.context = context;
        this.list = list;

    }

    public List<List<String>> getList() {
        return this.list != null? list : null;
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
    public List<String> getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder  viewHolder ;
        if(convertView == null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.table_listview_item,null);
            viewHolder.table1_tv01 = (TextView) convertView.findViewById(R.id.table1_tv01);
            viewHolder.table1_tv02 = (TextView) convertView.findViewById(R.id.table1_tv02);
            viewHolder.table1_tv03 = (TextView) convertView.findViewById(R.id.table1_tv03);
            viewHolder.table1_tv04 = (TextView) convertView.findViewById(R.id.table1_tv04);
            viewHolder.table1_tv05 = (TextView) convertView.findViewById(R.id.table1_tv05);
            viewHolder.table1_tv06 = (TextView) convertView.findViewById(R.id.table1_tv06);
            viewHolder.table1_tv07 = (TextView) convertView.findViewById(R.id.table1_tv07);
            id = new int[]{R.id.table1_tv01,R.id.table1_tv02,R.id.table1_tv03,R.id.table1_tv04,R.id.table1_tv05,R.id.table1_tv06,R.id.table1_tv07};

            View[] views = new View[id.length];

            //添加单元格点击事件
            for(int i = 0; i < id.length; i++) {
                View tv = convertView.findViewById(id[i]);
                tv.setOnClickListener(clickListener);
                views[i] = tv;
            }

            //添加每行的点击事件
				/*for(int i = 0 ; i < from.length; i++) {
					View tv = v.findViewById(row_hlistview[i]);
				}*/

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.table1_tv01.setText(list.get(position).get(0));
        viewHolder.table1_tv02.setText(list.get(position).get(1));
        viewHolder.table1_tv03.setText(list.get(position).get(2));
        viewHolder.table1_tv04.setText(list.get(position).get(3));
        viewHolder.table1_tv05.setText(list.get(position).get(4));
        viewHolder.table1_tv06.setText(list.get(position).get(5));
        viewHolder.table1_tv07.setText(list.get(position).get(6));

        return convertView;
    }


    public final class ViewHolder{
        public TextView table1_tv01;
        public TextView table1_tv02;
        public TextView table1_tv03;
        public TextView table1_tv04;
        public TextView table1_tv05;
        public TextView table1_tv06;
        public TextView table1_tv07;
    }

    protected View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "点击了:"+((TextView)v).getText(), Toast.LENGTH_SHORT).show();
//            context.startActivity(new Intent(context, ArraignmentRoomStatusActivity.class));
        }
    };
}
