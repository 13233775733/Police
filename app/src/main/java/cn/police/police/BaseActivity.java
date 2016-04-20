package cn.police.police;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by 王坤 on 2016/4/19.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvTitle;

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
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tvTitle = (TextView) findViewById(R.id.tv_title);
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
