package com.MyApp.mixcombo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Intent next=new Intent(Splash_Screen.this,CalculatorScreen.class);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.logo_animation);
        ImageView logo=(ImageView)findViewById(R.id.logo);
        logo.startAnimation(anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(next);
                finish();
            }
        },4000);
    }
}