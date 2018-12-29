package com.example.fly.performancetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * https://github.com/android-notes/SwissArmyKnife   UI调试工具
 * https://github.com/android-notes/Cockroach       降低Android非必要crash
 * https://github.com/android-notes
 *
 * https://github.com/friendlyrobotnyc/TinyDancer  可以检测 fps 图像每帧的耗时
 *
 * https://github.com/wasabeef/Takt   可以检测 fps
 *
 * https://blog.csdn.net/wangwwish/article/details/77719715  博客
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
