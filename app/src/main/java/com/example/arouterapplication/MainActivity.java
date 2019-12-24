package com.example.arouterapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.arouterapplication.bean.ARouterBean;

@Route(path = Content.ACTIVITY_URL_MAIN)
public class MainActivity extends AppCompatActivity {

    private TextView tv_helloword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_name);
        initView();
//        ARouter注入
        ARouter.getInstance().inject(this);

        tv_helloword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                界面跳转
                ARouter.getInstance().build(Content.ACTIVITY_URL_FRIST)
                        .withString("name", "ARouter")
                        .withParcelable("hello", new ARouterBean("hello"))
                        .navigation();
//                Uri跳转
//                Uri uri = Uri.parse(Content.ACTIVITY_URL_FRIST);
//                ARouter.getInstance().build(uri).navigation();
            }
        });
    }

    private void initView() {
        tv_helloword = (TextView) findViewById(R.id.tv_helloword);
    }
}
