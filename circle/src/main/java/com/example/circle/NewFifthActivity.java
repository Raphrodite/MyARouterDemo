package com.example.circle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselib.ARouterPath;
import com.example.circle.databinding.ActivityNewFifthBinding;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: NewFifthActivity
 * @Description:
 * @Author: Raphrodite
 * @CreateDate: 2023/1/30
 */
@Route(path = ARouterPath.NEW_FIFTH, group = ARouterPath.GROUP_NAME)
public class NewFifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding
        ActivityNewFifthBinding binding = ActivityNewFifthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
