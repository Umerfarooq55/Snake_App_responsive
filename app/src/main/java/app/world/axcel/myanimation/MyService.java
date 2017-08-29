package app.world.axcel.myanimation;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

public class MyService extends Service {
    int temp;
    MediaPlayer mp;
    private  int hightminus=00;
    private FrameLayout linearLayout;
    private BroadcastReceiver mReceiver;
    int newwdth;
    TranslateAnimation animation;
    private AnimationDrawable myFrameAnimation;
    private ImageView myFrameAnimationImageView;

    WindowManager.LayoutParams params;
    private  int SPLASH_TIME_OUT ;
    int duration;
    int deviceWidth;
    int deviceHeight;
    double screenInches;
    private WindowManager wm;


    String soundon;
    int x1,x2,y1,y2;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.


        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        QuitApplication();
        stopSelf();

    }



    public void onCreate() {
        super.onCreate();

        mp = MediaPlayer.create(MyService.this, R.raw.snake_sound);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;

        double wi=(double)deviceWidth/(double)displayMetrics.xdpi;
        double hi=(double)deviceHeight/(double)displayMetrics.ydpi;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        screenInches = Math.sqrt(x+y);


        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.snake, null);
        myFrameAnimationImageView = (ImageView)
                layout.findViewById(R.id.frameAnimationImageView);


        myFrameAnimationImageView
                .setBackgroundResource(R.drawable.frame_animation);
        myFrameAnimation = (AnimationDrawable)
                myFrameAnimationImageView.getBackground();


        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;
        if(close.serviceoff)
        {}
        if(!close.serviceoff)
        {//anim6();
            Random r = new Random();
            int count = r.nextInt(10 - 2) + 2;
 //anim2();
            //Toast.makeText(MyService.this,hightminus+"" , Toast.LENGTH_LONG).show();
          if(count==2)
            {
                anim5();
            }
            if(count==3)
            {
                anim4();
            }
            if(count==4)
            {
                anim3();
            }
            if(count==5)
            {
               // anim2();
                anim6();

            }
            if(count==6)
            {
                anim1();
            }
            if(count==7)
            {
                anim6();
            }
            if(count==8)
            {
                anim6();
            }
            if(count==9)
            {
                anim7();
            }
            if(count==10)
            {
                anim8();
            }


        }

        linearLayout = (FrameLayout) layout.findViewById(R.id.linear);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);
        params.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 0;
        params.y = 0;
        params.width = deviceWidth;
        params.height = deviceHeight;
        wm.addView(linearLayout, params);


        mReceiver = new LockScreenStateReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        filter.addAction(Intent.ACTION_USER_PRESENT);

        registerReceiver(mReceiver, filter);


//

    }




    public class LockScreenStateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }







    public void anim2() {
        if(screenInches>=7)
        {
            hightminus=deviceHeight+deviceHeight-1000;
            //   Toast.makeText(MyService.this,deviceHeight+"" , Toast.LENGTH_LONG).show();
            newwdth=deviceWidth/2;

            x1=deviceWidth/2;
            x2=deviceWidth/2;
            y1=deviceHeight+deviceHeight-1000;
            y2=deviceHeight - deviceHeight - 4000;
            SPLASH_TIME_OUT =21000;
            duration=40000;

        }
        else if(screenInches>=4&&screenInches<7)
        {
            hightminus=deviceHeight+deviceHeight-1000;
            //   Toast.makeText(MyService.this,deviceHeight+"" , Toast.LENGTH_LONG).show();
            newwdth=deviceWidth/2;

            x1=deviceWidth/2;
            x2=deviceWidth/2;
            y1=deviceHeight+deviceHeight-2500;
            y2=deviceHeight - deviceHeight - 2500;
            SPLASH_TIME_OUT =0;
            duration=45000;
        }
        animation = new TranslateAnimation(x1, x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to

        myFrameAnimationImageView.setRotation((float) 0.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);

        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {


                animation.cancel();
                myFrameAnimation.stop();
                Random r = new Random();
                int count = r.nextInt(10- 2) + 2;
                //  anim2();
                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim7();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim6();
                }
                if(count==9)
                {
                    anim7();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);
    }

    public void anim3() {
        if(screenInches>=7)
        {
            hightminus=(deviceHeight/2)-600;
            newwdth=deviceWidth-deviceWidth-deviceHeight+400;
            x1=deviceWidth-deviceWidth-deviceHeight+400;
            x2=deviceWidth + 1600;
            y1=(deviceHeight/2)-600;
            y2=(deviceHeight/2)-600;
            SPLASH_TIME_OUT =25000;
            duration=40000;
        }
        else if(screenInches>=4&&screenInches<7)
        {

            x1=deviceWidth-deviceWidth-1500;
            x2=deviceWidth + 12000;
            y1=1;
            y2=1;
            SPLASH_TIME_OUT =18000;
            duration=40000;
        }
        animation = new TranslateAnimation(x1,x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 90.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                animation.cancel();
                myFrameAnimation.stop();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;

                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim7();
                }
                if(count==5)
                {
                    anim4();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim6();
                }
                if(count==9)
                {
                    anim7();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);

    }

    public void anim4()
    {
        if(screenInches>=7)
        {
            hightminus=(deviceHeight/2)-600;
            newwdth=deviceWidth+300;
            x1=deviceWidth+800;
            x2=deviceWidth-deviceWidth-2200;
            y1=(deviceHeight/2)-600;
            y2=(deviceHeight/2)-600;
            duration=20000;
            SPLASH_TIME_OUT=23500;
        }
        else if(screenInches>=4&&screenInches<7)
        {

            x1=deviceWidth+1200;
            x2=deviceWidth-deviceWidth-2000;
            y1=1;
            y2=1;
            SPLASH_TIME_OUT =23000;
            duration=20000;
        }
        animation = new TranslateAnimation(x1,x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 270.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over

                myFrameAnimation.stop();
                animation.cancel();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;


                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {

                    anim1();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim7();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim6();
                }
                if(count==9)
                {
                    anim7();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);


    }
    public void anim5()
    {
        if(screenInches>=7)
        {
            hightminus=deviceHeight;
            newwdth=deviceWidth-deviceWidth-1000;
            x1=deviceWidth;
            x2=newwdth;
            y1=-hightminus;
            y2=hightminus+1600;
            duration=60000;
            SPLASH_TIME_OUT=40000;
        }
        else if(screenInches>=4&&screenInches<7)
        {
            hightminus=deviceHeight;
            newwdth=deviceWidth-deviceWidth-1000;
            x1=deviceWidth;
            x2=newwdth;
            y1=-hightminus;
            y2=hightminus+hightminus;
            SPLASH_TIME_OUT =26000;
            duration=45000;
        }
        animation = new TranslateAnimation(x1,x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 200.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {


                myFrameAnimation.stop();
                animation.cancel();
                Random r = new Random();
                int count = r.nextInt(10- 2) + 2;

                if(count==2)
                {
                    anim3();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim8();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim6();
                }
                if(count==9)
                {
                    anim7();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);


    }
    public void anim6()
    {
        if(screenInches>=7)
        {

            x1=deviceWidth+400;
            x2=deviceWidth-deviceWidth-1600;
            y1=deviceHeight;
            y2=(deviceHeight-deviceHeight)-1800;

            SPLASH_TIME_OUT=35000;

            duration=60000;
        }
        else if(screenInches>=4&&screenInches<7)
        {
            hightminus=deviceHeight+400;
            newwdth=deviceWidth+400;
            x1=deviceWidth/2;
            x2=deviceWidth-deviceWidth-1200;
            y1=-deviceHeight;
            y2=(deviceHeight-deviceHeight)-800;

            SPLASH_TIME_OUT =0;
            duration=45000;
        }
        animation = new TranslateAnimation(x1,x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 315.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                myFrameAnimation.stop();
                animation.cancel();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;

                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim3();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim5();
                }
                if(count==8)
                {
                    anim5();
                }
                if(count==9)
                {
                    anim7();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);


    }
    public void anim7()
    {
        if(screenInches>=7)
        {
            hightminus=deviceHeight;
            x1=(deviceWidth -deviceWidth)-800;
            x2=deviceWidth +1000;
            y1=deviceHeight;
            y2=(deviceHeight-deviceHeight)-1600;
            duration=60000;
            SPLASH_TIME_OUT=40000;
        }
        else if(screenInches>=4&&screenInches<7)
        {
            hightminus=deviceHeight;
            x1=(deviceWidth -deviceWidth)-600;
            x2=deviceWidth -400;
            y1=deviceHeight;
            y2=(deviceHeight-deviceHeight)-2500;
            SPLASH_TIME_OUT =38500;
            duration=45000;

        }
        animation = new TranslateAnimation(x1,x2,y1,y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 25.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                myFrameAnimation.stop();
                animation.cancel();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;

                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim5();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim4();
                }
                if(count==8)
                {
                    anim1();
                }
                if(count==9)
                {
                    anim4();
                }
                if(count==10)
                {
                    anim8();
                }

            }
        }, SPLASH_TIME_OUT);


    }
    public void anim8()
    {
        if(screenInches>=7)
        {
            hightminus=deviceHeight;
            x1=(deviceWidth -deviceWidth)-400;
            x2=deviceWidth +400;
            y1=(deviceHeight-deviceHeight)-1600;
            y2=deviceHeight+1500;
            duration=70000;
            SPLASH_TIME_OUT=35000;

        }
        else if(screenInches>=4&&screenInches<7)
        {
            hightminus=deviceHeight;
            x1=(deviceWidth -deviceWidth);
            x2=deviceWidth ;
            y1=(deviceHeight-deviceHeight)-2500;
            y2=deviceHeight+2000;
            SPLASH_TIME_OUT =31000;
            duration=45000;
        }
        animation = new TranslateAnimation(x1,x2,y1,y2);// new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 160.0);

        animation.start();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                myFrameAnimation.stop();
                animation.cancel();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;

                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim1();
                }
                if(count==6)
                {
                    anim1();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim3();
                }
                if(count==9)
                {
                    anim1();
                }
                if(count==10)
                {
                    anim3();
                }

            }
        }, SPLASH_TIME_OUT);


    }





    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(close.serviceoff)
        {

            startService(intent);
            return START_STICKY;


        }else
        {

            final float scale = getResources().getDisplayMetrics().density;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
            deviceWidth = displayMetrics.widthPixels;
            deviceHeight = displayMetrics.heightPixels;

            double wi=(double)deviceWidth/(double)displayMetrics.xdpi;
            double hi=(double)deviceHeight/(double)displayMetrics.ydpi;
            double x = Math.pow(wi,2);
            double y = Math.pow(hi,2);
            screenInches = Math.sqrt(x+y);
            if(screenInches>=7)
            {


                myFrameAnimationImageView.getLayoutParams().width = (int)(400*scale);//300//200//200
                myFrameAnimationImageView.getLayoutParams().height = (int)(1600*scale);//1200//800///1000

            }
            else if(screenInches>=4&&screenInches<7)
            {


                myFrameAnimationImageView.getLayoutParams().width = (int)(200*scale);//300//200//200
                myFrameAnimationImageView.getLayoutParams().height = (int)(800*scale);//1200//800///1000
            }








            soundon=(String) intent.getExtras().get("sound");

            if(soundon.equals("on"))
            {
                if(!mp.isPlaying())

                {
                    mp.start();
                    mp.setLooping(true);
                }
            }

            if(soundon.equals("of"))
            {
                if(mp.isPlaying())

                {
                    mp.start();
                    mp.setLooping(true);
                }
                mp.stop();

            }

            startService(intent);
            return START_STICKY;
        }


    }
    private void QuitApplication(){

        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }
    public void anim1() {
        if(screenInches>=7)
        {

            x1=(deviceWidth / 2) ;
            x2=(deviceWidth / 2);
            y1=-deviceHeight-200;
            y2=deviceHeight + 3500;
            duration=30000;
            SPLASH_TIME_OUT=15000;


        }
        else if(screenInches>=4&&screenInches<7)
        {
            x1=(deviceWidth / 2) ;
            x2=(deviceWidth / 2);
            y1=(deviceHeight-deviceHeight)-2550;
            y2=deviceHeight + 800;
            SPLASH_TIME_OUT =30000;
            duration=40000;

        }
        animation = new TranslateAnimation(x1,x2,y1 , y2); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(duration); // animation duration
        animation.setRepeatCount(-1); // animation repeat count
        animation.setRepeatMode(Animation.RESTART); // repeat animation (left to right, right to
        myFrameAnimationImageView.setRotation((float) 180.0);


        animation.startNow();

        myFrameAnimationImageView.startAnimation(animation);
        myFrameAnimation.start();
        myFrameAnimation.setOneShot(false);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                animation.cancel();
                myFrameAnimation.stop();
                Random r = new Random();
                int count = r.nextInt(10 - 2) + 2;
                //  anim2();
                if(count==2)
                {
                    anim5();
                }
                if(count==3)
                {
                    anim4();
                }
                if(count==4)
                {
                    anim3();
                }
                if(count==5)
                {
                    anim7();
                }
                if(count==6)
                {
                    anim8();
                }
                if(count==7)
                {
                    anim6();
                }
                if(count==8)
                {
                    anim6();
                }
                if(count==9)
                {
                    anim4();
                }
                if(count==10)
                {
                    anim8();
                }


                // anim2();
            }
        }, SPLASH_TIME_OUT);

    }


}

