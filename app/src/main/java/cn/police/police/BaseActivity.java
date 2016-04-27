package cn.police.police;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**Created by 王坤 on 2016/4/19*/

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvTitle;
    protected LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        initToolbar();
        initView();
    }

    //设置Layout布局文件
    public abstract void setLayout();

    //初始化tootbar 工具条
    public void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back= (LinearLayout) findViewById(R.id.head_back);
        if (toolbar !=null){
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            tvTitle = (TextView) findViewById(R.id.tv_title);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseActivity.this.onBackPressed();
                overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
            }
        });

    }

    //获取toolbar 工具条
    public Toolbar getToolbar() {
        return toolbar;
    }

    //初始化页面控件
    public abstract void initView();

    //设置页面标题
    public void setTvTitle(String title){
        tvTitle.setText(title);
    }


}
