package com.qgs.gd.fenzu;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Yuan yuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yuan = findViewById(R.id.yuan);

        ValueAnimator animator = ValueAnimator.ofFloat(0,100);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float current = (float) animation.getAnimatedValue();
                yuan.setmCurrent((int) current);
            }
        });
        animator.start();

        yuan.setOnLoadingCompleteListener(new Yuan.OnLoadingCompleteListener() {
            @Override
            public void complete() {
                Toast.makeText(MainActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,TwoActivity.class));
                finish();
            }
        });
    }
}
