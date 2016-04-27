package cn.police.police.page;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.police.police.R;

public class YuYueAdapter extends BaseAdapter {


    private List<String[]> list ;
    private Context context;
    private LayoutInflater inflater;

    public YuYueAdapter(Context context,List<String[]> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list=list;
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
            convertView = this.inflater.inflate(R.layout.reserve_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        String[] item = list.get(position);

        holder.tv1.setText(item[0]);

        holder.tv2.setText(item[1]);

        if (item[2].equals("false")){
            holder.image1.setImageResource(R.drawable.status_red);

        }else{
            holder.image1.setImageResource(R.drawable.status_green);

        }
        return convertView;
    }

    static class ViewHolder {

        @InjectView(R.id.tv1)
        TextView tv1;
        @InjectView(R.id.tv2)
        TextView tv2;

        @InjectView(R.id.image1)
        ImageView image1;


        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
    //可预约
    @OnClick(R.id.btn_kyy)
    public void btn_kyy(){
        context.startActivity(new Intent(context,DetailsActivity.class));

    }

}