package com.example.myarouter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselib.ARouterPath;
import com.example.circle.PersonBean;
import com.example.myarouter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //视图绑定
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //跳转Activity（不带参数）
        binding.tvFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.跳转到新的Activity
                ARouter.getInstance().build(ARouterPath.NEW_FIRST).navigation();
            }
        });

        //跳转Activity（带参数）
        binding.tvSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2.跳转到新的Activity
                ARouter.getInstance().build(ARouterPath.NEW_SECOND)
                        .withString("dota2", "yyf")
                        .withString("csgo", "zywoo")
                        .withParcelable("value", new PersonBean("apex", "pubg"))
                        .navigation();
            }
        });

        //startActivityForResult
        binding.tvThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3. 类似startActivityForResult
                ARouter.getInstance().build(ARouterPath.NEW_THIRD)
                        .withString("dota2", "yyf")
                        .withString("csgo", "zywoo")
                        .navigation(MainActivity.this, 123);
            }
        });

        //url跳转
        binding.tvFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4. url跳转
                ARouter.getInstance().build(ARouterPath.NEW_FOURTH)
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
            }
        });

        //拦截器
        binding.tvFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5. 拦截器
                ARouter.getInstance().build(ARouterPath.NEW_FIFTH, ARouterPath.GROUP_NAME)
                        .navigation(MainActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("zrzr", "path = " + postcard.getPath() + ", group = "
                                        + postcard.getGroup());
                                //路由被发现时调用
                                Log.e("zrzr", "onFound");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                //路由丢失时调用
                                Log.e("zrzr", "onLost");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                //路由到达之后调用
                                Log.e("zrzr", "onArrival");
//                                finish();
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                //路由被拦截时调用
                                Log.e("zrzr", "onInterrupt");
                            }
                        });
            }
        });

        //降级策略
        binding.tvSixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单独降级
                ARouter.getInstance().build("/xx/xx")
                        .navigation(MainActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {

                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("zrzr", "onLost = 局部降级");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {

                            }
                        });

                //全局降级
//                ARouter.getInstance().build("/xx/xx").navigation();
            }
        });

//        jumpToFragment();
    }

    private void jumpToFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(ARouterPath.NEW_FRAGMENT).navigation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 123:
                Log.e("zrzr", "onActivityResult = " + "获取到跳转界面返回的数据");
                String majorMvp = data.getStringExtra("astralis");
                String tiJoker = data.getStringExtra("psg.lgd");
                Log.e("zrzr", "majorMvp = " + majorMvp + ", tiJoker = " + tiJoker);
                break;
        }
    }
}