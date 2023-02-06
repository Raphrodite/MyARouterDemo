package com.example.circle;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: DegradeServiceImpl
 * @Description: 降级容错服务
 * @Author: Raphrodite
 * @CreateDate: 2023/1/31
 */

@Route(path = DegradeServiceImpl.PATH)
public class DegradeServiceImpl implements DegradeService {

    public static final String PATH = "/service/DegradeServiceImpl";

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.e("zrzr", "全局降级");
    }

    @Override
    public void init(Context context) {

    }
}
