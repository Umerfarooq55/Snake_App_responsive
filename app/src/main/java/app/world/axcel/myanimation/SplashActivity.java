package app.world.axcel.myanimation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    private ProgressDialog pDialog;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pDialog = new ProgressDialog(SplashActivity.this);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                pDialog.dismiss();
                Intent i = new Intent(SplashActivity.this, start.class);
                startActivity(i);


                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}