package com.example.circle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselib.ARouterPath;
import com.example.circle.databinding.ActivityNewSecondBinding;

/**
 * * Copyright * 圣通电力
 *
 * @ProjectName: MyARouter
 * @Package: com.example.circle
 * @ClassName: NewSecondActivity
 * @Description: 新的Activity 接收的 带参数
 * @Author: Raphrodite
 * @CreateDate: 2023/1/29
 */
@Route(path = ARouterPath.NEW_SECOND)
public class NewSecondActivity extends AppCompatActivity {

    @Autowired
    String dota2;

    @Autowired
    String csgo;

    @Autowired(name = "value")
    PersonBean personBean;

//    @Autowired
//    PersonBean personBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        //viewBinding
        ActivityNewSecondBinding binding = ActivityNewSecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("zrzr", "dota2 = " + dota2 + ", csgo = " + csgo + ", person = "
                + personBean.toString());
    }
}
