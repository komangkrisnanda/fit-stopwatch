package id.decode.fitstopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity {

    Button btn_start, btn_finish;
    ImageView img_anchor;
    Animation roundingAlone;
    Chronometer appTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btn_start   = findViewById(R.id.btn_start);
        btn_finish  = findViewById(R.id.btn_finish);
        img_anchor  = findViewById(R.id.img_anchor);
        appTimer    = findViewById(R.id.app_timer);

        //set optional animation

        btn_finish.setAlpha(0);

        //load animations
        roundingAlone       = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import fonts
        Typeface MMedium    = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //customize fonts
        btn_start.setTypeface(MMedium);

        //events

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_anchor.startAnimation(roundingAlone);
                btn_finish.animate().alpha(1).translationY(-80).setDuration(300).start();
                btn_start.animate().alpha(0).setDuration(300).start();

                //start timer
                appTimer.setBase(SystemClock.elapsedRealtime());
                appTimer.start();
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_start.animate().alpha(1).setDuration(300).start();
                btn_finish.animate().alpha(0).setDuration(300).start();

                //stop animation & clear time interval

                img_anchor.clearAnimation();
                appTimer.stop();
            }
        });
    }
}
