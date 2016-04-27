package cn.police.police.page;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.police.police.R;

/**
 * wangkun
 */

public class ArraignedRoomAdaapter extends BaseAdapter {


    private List<String[]> list ;
    private Context context;
    private LayoutInflater inflater;




    public ArraignedRoomAdaapter(Context context ,List<String[]> list){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = this.inflater.inflate(R.layout.fragment3_housestatus_item, parent, false);
            holder = new ViewHolder(convertView);
            holder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
        }

        String[] item = list.get(position);

        holder.tv1.setText(item[0]);

        holder.tv2.setText(item[1]);

        if (item[2].equals("false")){
            holder.tv1.setBackgroundColor(this.context.getResources().getColor(R.color.red));
        }else{
            holder.tv1.setBackgroundColor(this.context.getResources().getColor(R.color.green));

        }


        return convertView;
    }

    static class ViewHolder{

        @InjectView(R.id.tv1)
        TextView tv1;
        @InjectView(R.id.tv2)
        TextView tv2;
        public ViewHolder(View view)
        {
            ButterKnife.inject(this, view);
        }
    }
}
