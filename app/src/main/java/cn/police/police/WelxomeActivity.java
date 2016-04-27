package cn.police.police;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.police.police.announcement.NoticeAnnouncementActivity;

public class WelxomeActivity extends BaseActivity {

    private Button btn_arraignedroom;//转到看守所提审室
    private Button btn_noticeannouncement;//转到通知公告

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_welxome);
        btn_arraignedroom= (Button) findViewById(R.id.btn_arraignedroom);
        btn_noticeannouncement = (Button) findViewById(R.id.btn_noticeannouncement);

    }
    @Override
    public void initView() {
        setTvTitle("首页");
        back.setVisibility(View.GONE);

        ButterKnife.inject(this);
    }



    @OnClick(R.id.btn_arraignedroom)
    public void btn_arraignedroom(){
        Toast.makeText(WelxomeActivity.this,"到提审室预订",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(WelxomeActivity.this, IndexActivity.class));
    }
    @OnClick(R.id.btn_noticeannouncement)
    public void btn_noticeannouncement(){
        Toast.makeText(WelxomeActivity.this,"到通知公告",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(WelxomeActivity.this, NoticeAnnouncementActivity.class));
    }
}
