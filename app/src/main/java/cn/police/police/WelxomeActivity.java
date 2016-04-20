package cn.police.police;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelxomeActivity extends BaseActivity {



    @Override
    public void setLayout() {
        setContentView(R.layout.activity_welxome);
        bt= (Button) findViewById(R.id.btn_onclick);

    }

    private Button bt;
    @Override
    public void initView() {
        setTvTitle("首页");
        ButterKnife.inject(this);
    }



    @OnClick(R.id.btn_onclick)
    public void btn_click(){
        startActivity(new Intent(WelxomeActivity.this,IndexActivity.class));
    }


}
