package com.example.circle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselib.ARouterPath;
import com.example.circle.databinding.ActivityNewFourthBinding;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: NewFourthActivity
 * @Description:
 * @Author: Raphrodite
 * @CreateDate: 2023/1/29
 */
@Route(path = ARouterPath.NEW_FOURTH)
public class NewFourthActivity extends AppCompatActivity {

    @Autowired
    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        //viewBinding
        ActivityNewFourthBinding binding = ActivityNewFourthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("zrzr", "url = " + url);
        binding.wv.loadUrl(url);
    }
}
