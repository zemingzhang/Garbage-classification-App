package com.example.zemingzhang.radioassistant;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    static final String TAG = "SplashActivity";
    private final int SPLASH_DISPLAY_LENGHT = 3000; // 3 sec delay
    private TextView mTextView;


    static Intent createIntent(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        int maxExtent = Math.max(display.getWidth(), display.getHeight());

        Intent intent;
        if (maxExtent > 1200) {
            Log.i(TAG, "starting tablet ui");
            intent = new Intent(activity, MainActivity.class);
        } else {
            Log.i(TAG, "starting phone ui");
            intent = new Intent(activity, MainActivity.class);
        }
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int rNumber = getRandom();
        setContentView(R.layout.splash);
        changeText(rNumber);


        new Handler().postDelayed(new Runnable() {
            public void run() {
                // make a new launch later for phone and tablet
                Intent mainIntent = new Intent(SplashActivity.this,
                        MainActivity.class);
                // only support phone now
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }

    private int getRandom(){
        Random random=new Random();
        return random.nextInt(3);
    }

    private void changeText(int i){
        CharSequence  s1=this.getString(R.string.app_sentence);
        switch (i){
            case 0:
                 s1=this.getString(R.string.app_sentence1);
                 break;
            case 1:
                 s1=this.getString(R.string.app_sentence2);
                 break;
            default:
        }

        mTextView = findViewById(R.id.textView2);
        mTextView.setText(s1);

    }

}
