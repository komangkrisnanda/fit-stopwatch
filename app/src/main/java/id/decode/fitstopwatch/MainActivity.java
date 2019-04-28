package id.decode.fitstopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtSplash, txtSubSplash;
    Button btnGet;
    Animation atg, btgone, btgtwo;
    ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSplash       = findViewById(R.id.txtSplash);
        txtSubSplash    = findViewById(R.id.txtSubSplash);
        btnGet          = findViewById(R.id.btn_get);
        imgSplash       = findViewById(R.id.img_splash);

        atg             = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone          = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo          = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        imgSplash.startAnimation(atg);

        txtSplash.startAnimation(btgone);
        txtSubSplash.startAnimation(btgone);

        btnGet.startAnimation(btgtwo);

        //passing event

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i    = new Intent(MainActivity.this, StopwatchActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        //import font;
        Typeface MLight     = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium    = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular   = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //customize font

        txtSplash.setTypeface(MRegular);
        txtSubSplash.setTypeface(MLight);
        btnGet.setTypeface(MMedium);
    }
}
