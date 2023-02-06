package com.example.circle;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.example.baselib.ARouterPath;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: UseFirstIInterceptor
 * @Description: 第一个拦截器
 * @Author: Raphrodite
 * @CreateDate: 2023/1/30
 */
@Interceptor(priority = 7)
public class UseFirstIInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        //线程名称
        String name = Thread.currentThread().getName();
        if (postcard.getPath().equals(ARouterPath.NEW_FIFTH)) {
            Log.e("zrzr", "UseFirstIInterceptor 拦截器 ：" + "线程名称 -- " + name);
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.e("zrzr", "UseFirstIInterceptor 拦截器 ：init");
    }
}
