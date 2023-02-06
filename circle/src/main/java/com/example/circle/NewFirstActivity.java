package com.example.circle;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselib.ARouterPath;
import com.example.circle.databinding.ActivityNewFirstBinding;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: NewFirstActivity
 * @Description: 新界面 不同Module
 * @Author: Raphrodite
 * @CreateDate: 2023/1/29
 */
@Route(path = ARouterPath.NEW_FIRST)
public class NewFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding
        ActivityNewFirstBinding binding = ActivityNewFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
