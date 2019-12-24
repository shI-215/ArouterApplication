package com.example.arouterapplication;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ARouterApplication extends Application {
    //    ARouter调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
//            打印日志
            ARouter.openLog();
//            开启调试模式
            ARouter.openDebug();
        }
//        初始化
        ARouter.init(ARouterApplication.this);
    }
}
