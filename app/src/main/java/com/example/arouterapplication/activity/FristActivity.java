package com.example.arouterapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterapplication.bean.ARouterBean;
import com.example.arouterapplication.Content;
import com.example.arouterapplication.R;

@Route(path = Content.ACTIVITY_URL_FRIST)
public class FristActivity extends AppCompatActivity {
    @Autowired()
    String name;

    @Autowired(name = "hello")
    ARouterBean aRouterBean;

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        initView();
        //        ARouter注入(此行必须注入！！！否则注解无效)
        ARouter.getInstance().inject(this);
        tv_text.setText(name + " , " + aRouterBean);
    }

    private void initView() {
        tv_text = (TextView) findViewById(R.id.tv_text);
    }
}
