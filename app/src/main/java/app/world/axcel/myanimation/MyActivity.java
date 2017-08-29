package app.world.axcel.myanimation;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static app.world.axcel.myanimation.R.drawable.ic_splash_icon;



public class MyActivity extends Activity {
    NotificationCompat.Builder notification;
    TaskStackBuilder stackBuilder;
    Intent resultIntent;
    PendingIntent pIntent;
    NotificationManager manager;
    public final static int REQUEST_CODE = -1010101;
    private AdView mAdView;
    MediaPlayer mp;
    InterstitialAd mInterstitialAd;
    Intent intent;
    private static int SPLASH_TIME_OUT = 10000;
    int ynum;
    boolean t1,t2,t3;
    EditText customtime;

    boolean on,of;
    String sound;


    public static  boolean soundon,soundof;
    int value;

    String newhight="1600",newwidth="400";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        customtime=(EditText)findViewById(R.id.edittext);



        ImageView icback = (ImageView) findViewById(R.id.icback);
        icback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyActivity.this,start.class);
                startActivity(i);
            }
        });




        final RadioButton oneradio = (RadioButton) findViewById(R.id.rb_one);
        final RadioButton tworadio = (RadioButton) findViewById(R.id.rb_two);
        final RadioButton threeradio = (RadioButton) findViewById(R.id.rb_three);
        final ImageButton soundofbtn =(ImageButton)findViewById(R.id.sound_switchof);
        final ImageButton soundonbtn=(ImageButton)findViewById(R.id.sound_switchon);
        soundon=true;
        soundof=false;
        soundofbtn.setVisibility(View.INVISIBLE);
        soundonbtn.setVisibility(View.VISIBLE);
        sound="on";
        soundofbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound="on";

                soundofbtn.setVisibility(View.INVISIBLE);
                soundonbtn.setVisibility(View.VISIBLE);

            }
        });
        soundonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sound="of";
                soundofbtn.setVisibility(View.VISIBLE);
                soundonbtn.setVisibility(View.INVISIBLE);


            }
        });


        oneradio.setChecked(true);
        t1=true;

        oneradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (oneradio.isChecked()) {
                    t1=true;
                    t2=false;
                    t3=false;
                    tworadio.setChecked(false);
                    threeradio.setChecked(false);
                }


            }
        });
        tworadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tworadio.isChecked()) {
                    t1=false;
                    t2=true;
                    t3=false;
                    oneradio.setChecked(false);
                    threeradio.setChecked(false);
                }


            }
        });
        threeradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (threeradio.isChecked()) {
                    t1=false;
                    t2=false;
                    t3=true;
                    tworadio.setChecked(false);
                    oneradio.setChecked(false);
                }


            }
        });




        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequestu = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequestu);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        Button buttonOne = (Button) findViewById(R.id.movenn);
        buttonOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                if(customtime.getText().toString().isEmpty()&& t3)
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Time",Toast.LENGTH_SHORT).show();
                }
                else if(t3)
                {
                    ynum  = Integer.parseInt(customtime.getText().toString());
                    close.serviceoff=false;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        checkDrawOverlayPermission();

                    } else {
                        startNotification();

                        minimizeApp();

                        if(t1)
                        {
                            SPLASH_TIME_OUT=0;
                        }
                        if(t2)
                        {
                            SPLASH_TIME_OUT=10000;
                        }
                        if(t3)
                        {
                            SPLASH_TIME_OUT=ynum*1000;
                        }
                        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                // Start your app main activity

                                intent = new Intent(MyActivity.this, MyService.class);
                                intent.putExtra("sound",sound);

                                startService(intent);


                            }
                        }, SPLASH_TIME_OUT);



                    }
                }
                else
                {
                    close.serviceoff=false;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        checkDrawOverlayPermission();

                    } else {
                        startNotification();

                        minimizeApp();

                        if(t1)
                        {
                            SPLASH_TIME_OUT=0;
                        }
                        if(t2)
                        {
                            SPLASH_TIME_OUT=10000;
                        }
                        if(t3)
                        {
                            SPLASH_TIME_OUT=ynum*1000;
                        }
                        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                // Start your app main activity

                                intent = new Intent(MyActivity.this, MyService.class);
                                intent.putExtra("sound",sound);

                                startService(intent);


                            }
                        }, SPLASH_TIME_OUT);



                    }

                }

                // ynum  = Integer.parseInt(customtime.getText().toString());

                //   Toast.makeText(getApplicationContext(),ynum*1000+"",Toast.LENGTH_SHORT).show();

            }
        });



    }

    // @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkDrawOverlayPermission() {
        Log.v("App", "Package Name: " + getApplicationContext().getPackageName());

        /** check if we already  have permission to draw over other apps**/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(MyActivity.this)) {
                Log.v("App", "Requesting Permission" + Settings.canDrawOverlays(MyActivity.this));
                /** if not construct intent to request permission**/
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getApplicationContext().getPackageName()));
            /* request permission via start activity for result */

                startActivityForResult(intent, REQUEST_CODE); //It will call onActivityResult Function After you press Yes/No and go Back after giving permission
            } else {
                Log.v("App", "We already have permission for it.");

                minimizeApp();

                startNotification();
                if(t1)
                {
                    SPLASH_TIME_OUT=0;
                }
                if(t2)
                {
                    SPLASH_TIME_OUT=10000;
                }
                if(t3)
                {
                    SPLASH_TIME_OUT=ynum*1000;
                }
                new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity

                        intent = new Intent(MyActivity.this, MyService.class);
                        intent.putExtra("sound",sound);
                        // intent.putExtra("hight",newhight);
                        // intent.putExtra("width",newwidth);


                        startService(intent);

                    }
                }, SPLASH_TIME_OUT);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v("App", "OnActivity Result.");
        //check if received result code
        //  is equal our requested code for draw permission
        if (requestCode == REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    //Permission Granted by Overlay!!!
                    //Do your Stuff
                }
            }
        }
    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();





        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }




    public void startNotification() {
        // TODO Auto-generated method stub
        //Creating Notification Builder

        notification = new NotificationCompat.Builder(MyActivity.this);
        //Title for Notification

        notification.setContentTitle("Serpent On Phone Joke");
        //Message in the Notification
        notification.setContentText("Click To Remove Snake");

        notification.setSmallIcon(ic_splash_icon);


        notification.setOngoing(true);
        notification.setAutoCancel(true );

        //Creating new Stack Builder
        stackBuilder = TaskStackBuilder.create(MyActivity.this);
        stackBuilder.addParentStack(start.class);
        //Intent which is opened when notification is clicked
        resultIntent = new Intent(MyActivity.this, close.class);



        stackBuilder.addNextIntent(resultIntent);

        pIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pIntent);


        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification.build());

        //  manager.cancelAll();
    }



    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void minimizeApp() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }



}

