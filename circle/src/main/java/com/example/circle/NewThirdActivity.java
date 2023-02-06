package com.example.circle;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselib.ARouterPath;
import com.example.circle.databinding.ActivityNewThirdBinding;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: NewThirdActivity
 * @Description: 类似startActivityForResult
 * @Author: Raphrodite
 * @CreateDate: 2023/1/29
 */
@Route(path = ARouterPath.NEW_THIRD)
public class NewThirdActivity extends AppCompatActivity {

    @Autowired
    String dota2;

    @Autowired
    String csgo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        //viewBinding
        ActivityNewThirdBinding binding = ActivityNewThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //数据
        Intent intent = new Intent();
        intent.putExtra("astralis", "device");
        intent.putExtra("psg.lgd", "ame");

        //返回
        setResult(123, intent);
    }
}
