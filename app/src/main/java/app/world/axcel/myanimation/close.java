package app.world.axcel.myanimation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class close extends AppCompatActivity {
    public static boolean serviceoff;
String isnoti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceoff = true;
        setContentView(R.layout.activity_close);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -20;
        params.height = 250;
        params.width = 250;
        params.y = -10;

        this.getWindow().setAttributes(params);
        MyService service = new MyService();
        service.stopSelf();
        stopService(new Intent(this, MyService.class));

        FrameLayout frame = (FrameLayout) findViewById(R.id.framee);
        frame.setVisibility(View.GONE);
        isnoti=getIntent().getStringExtra("value");
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {



                MyService service = new MyService();
                service.stopSelf();

                stopService(new Intent(close.this, MyService.class));

                Intent i = new Intent(close.this, MyActivity.class);
i.putExtra("value",isnoti);
                startActivity(i);


            }
        }, 10);

    }


    @Override
    protected void onDestroy() {

        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
    }
}


