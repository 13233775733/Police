package cn.police.police.announcement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.police.police.R;
import cn.police.police.announcement.activity.Alarm110Activity;
import cn.police.police.utils.BadgeView;
import cn.police.police.utils.URLStringUtil;

/*2016/4/25,lhp*/

/**
 * 通知公告主界面
 */
public class NoticeAnnouncementActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;//标题
    private TextView tv_daypush;//每日推送
    private LinearLayout head_back;//返回
    private LinearLayout noticeanno_110alarm_ll;//转到110接处警界面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notice_announcement);
        initview();
        setclick();
    }

    public void initview() {
        tv_daypush = (TextView) findViewById(R.id.tv_daypush);//每日推送
        daypushnotice();

        title = (TextView) findViewById(R.id.tv_noticetitle);
//        title.getPaint().setFakeBoldText(true);//标题加粗
        head_back = (LinearLayout) findViewById(R.id.head_back);//返回
//        noticeanno_110alarm_ll = (LinearLayout) findViewById(R.id.noticeanno_110alarm_ll);

    }

    public void setclick() {
        head_back.setOnClickListener(this);
        noticeanno_110alarm_ll.setOnClickListener(this);
    }

    /**给组件设置提示信息样式并显示*/
    public void daypushnotice() {
        BadgeView badgeView_daypush = new BadgeView(this, tv_daypush);
        badgeView_daypush.setText("10");
        badgeView_daypush.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        badgeView_daypush.setTextColor(Color.WHITE);
        badgeView_daypush.setBadgeBackgroundColor(Color.RED);
        badgeView_daypush.setTextSize(10);
        badgeView_daypush.toggle();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head_back:
                finish();
                break;
//            case R.id.noticeanno_110alarm_ll:
//                startActivity(new Intent(NoticeAnnouncementActivity.this, Alarm110Activity.class));
//                break;
            case R.id.tv_daypush:

                break;
        }
    }
    /**请求后台获取每日或每周推送信息*/
    public void requestmessage(){
        String noticebaseUrl = URLStringUtil.getnoticeBaseUrl();

    }


    /**
     * 显示每日推送子项ListView的Adapter
     */
    public class NoticeDayPushAdapter extends BaseAdapter{
        Context context;

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder ;
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.listview_notice_daypush_item,null);
                viewHolder.tv_daypush_itemtitle = (TextView) convertView.findViewById(R.id.tv_daypush_itemtitle);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

//            viewHolder.tv_daypush_itemtitle.setText();


            return convertView;
        }
    }

    public class ViewHolder{
        private TextView tv_daypush_itemtitle;//每日推送子项的title
    }

}
