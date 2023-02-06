package com.example.baselib;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by zr
 * on 2022/7/6
 */
public class BaseApplication extends Application {

    /**
     * ARouter调试开关
     */
    private static boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ARouter
        initARouter(this);
    }

    /**
     * 初始化ARouter
     * @param application
     */
    public static void initARouter(BaseApplication application) {
        //这两行必须写在init之前，否则这些配置在init过程中将无效  buildConfig.DEBUG
        if(isDebugARouter) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        //尽可能早，推荐在Application中初始化
        ARouter.init(application);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
