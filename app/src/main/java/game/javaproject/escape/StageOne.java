package game.javaproject.escape;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StageOne extends AppCompatActivity {

    private StageOneView stageOneView;
    public static long ammo = 10;
    long st, fn;
    boolean we1=false,we2=false,we3=false,we4=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_stage_one);


        stageOneView=findViewById(R.id.stageOneView);

        final Button up=findViewById(R.id.upore);
        final Button down=findViewById(R.id.niche);
        final Button left=findViewById(R.id.bam);
        final Button right=findViewById(R.id.dan);
        final Button guli=findViewById(R.id.fire_button);
        final Button pause = findViewById(R.id.pause);
        final Button exit = findViewById(R.id.ex_button);


        final RelativeLayout tt = findViewById(R.id.mora);

        final TextView textView=findViewById(R.id.ammo);
        textView.setText(new Integer((int)ammo).toString());

        pause.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                DrawingThread.pauseFlag=!DrawingThread.pauseFlag;
                if(DrawingThread.pauseFlag==true) {
                    pause.setBackground(getDrawable(R.drawable.ammo1));
                    up.setVisibility(View.INVISIBLE);
                    down.setVisibility(View.INVISIBLE);
                    left.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    guli.setVisibility(View.INVISIBLE);
                    exit.setVisibility(View.VISIBLE);
                }else{
                    pause.setBackground(getDrawable(R.drawable.ammo));
                    up.setVisibility(View.VISIBLE);
                    down.setVisibility(View.VISIBLE);
                    left.setVisibility(View.VISIBLE);
                    right.setVisibility(View.VISIBLE);
                    guli.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.INVISIBLE);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stageOneView.drawingThread.stopThread();
                try {
                    Intent intent = new Intent(StageOne.this, ZeroSuccess.class);
                    startActivity(intent);
                    stageOneView.drawingThread.start();
                    finish();
                }catch (Exception e){
                    int pid = android.os.Process.myPid();
                    android.os.Process.killProcess(pid);
                    finish();
                    System.exit(0);
                }
            }
        });

        if(!DrawingThread.pauseFlag) {



            up.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY>=((345*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY<=((708*stageOneView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageOne.this, FirstSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.animCharUp;
                        stageOneView.drawingThread.ground.startMovingPlayerToUp();


                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.upStill;
                        stageOneView.drawingThread.ground.stopMovingPlayerUp();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());
                    }

                    return false;
                }
            });

            down.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY>=((345*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY<=((708*stageOneView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageOne.this, FirstSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.animCharDown;
                        stageOneView.drawingThread.ground.startMovingPlayerToDown();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.downStill;
                        stageOneView.drawingThread.ground.stopMovingPlayerDown();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    }

                    return false;
                }
            });

            left.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY>=((345*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY<=((708*stageOneView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageOne.this, FirstSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.animCharBack;
                        stageOneView.drawingThread.ground.startMovingPlayerToLeft();
                        stageOneView.drawingThread.ground.startMovingToRight();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.backStill;
                        stageOneView.drawingThread.ground.stopMovingPlayerLeft();
                        stageOneView.drawingThread.ground.stopMovingRight();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    }

                    return false;
                }
            });

            right.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY>=((345*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY<=((708*stageOneView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageOne.this, FirstSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.animCharFront;
                        stageOneView.drawingThread.ground.startMovingPlayerToRight();
                        stageOneView.drawingThread.ground.startMovingToLeft();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.still;
                        stageOneView.drawingThread.ground.stopMovingPlayerRight();
                        stageOneView.drawingThread.ground.stopMovingLeft();

                        if (we1 == false && stageOneView.drawingThread.ground.weapon1.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageOneView.drawingThread.ground.weapon2.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageOneView.drawingThread.ground.weapon3.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageOneView.drawingThread.ground.weapon4.isGained(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }
                        //System.out.println(stageOneView.drawingThread.ground.player.centerX+" "+stageOneView.drawingThread.ground.player.centerX);

                        if (stageOneView.drawingThread.ground.enemy1.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy2.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy3.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy4.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy5.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy6.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy7.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy8.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy9.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy10.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageOneView.drawingThread.ground.enemy11.isTouched(new Point(stageOneView.drawingThread.ground.player.centerX, stageOneView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageOneView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    }

                    return false;
                }
            });


            guli.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY>=((345*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageOneView.drawingThread.displayY)/1080) &&
                            stageOneView.drawingThread.ground.player.centerY<=((708*stageOneView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageOne.this, FirstSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }
                    if (ammo > 0) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                guli.setBackground(getDrawable(R.drawable.fire));
                            }
                            st = event.getEventTime();
                            Point p = new Point(stageOneView.drawingThread.ground.player.centerX + (stageOneView.drawingThread.ground.topleftPoint.x * -1), stageOneView.drawingThread.ground.player.centerY);

                            if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.still) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.stillFire;
                                stageOneView.drawingThread.ground.startFire(p);
                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.backStill) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.backStillFire;

                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.upStill) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.upFire;
                                stageOneView.drawingThread.ground.fireUp(p);
                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.downStill) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.downFire;
                                stageOneView.drawingThread.ground.fireDown(p);
                            }
                            textView.setText(new Integer((int) ammo).toString());

                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                guli.setBackground(getDrawable(R.drawable.fire1));
                            }
                            stageOneView.drawingThread.ground.stopFire();
                            fn = event.getEventTime();

                            ammo = ammo - ((fn - st) * 10) / 1000;
                            if (ammo < 0) {
                                ammo = 0;
                            }

                            if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.stillFire) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.still;
                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.backStillFire) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.backStill;
                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.upFire) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.upStill;
                            } else if (stageOneView.drawingThread.ground.player.animChar == stageOneView.drawingThread.ground.player.downFire) {
                                stageOneView.drawingThread.ground.player.animChar = stageOneView.drawingThread.ground.player.downStill;
                            }
                            textView.setText(new Integer((int) ammo).toString());

                        }

                    }
                    System.out.println(ammo);
                    return false;
                }
            });

        }

//        guli.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Point p = new Point(stageOneView.drawingThread.ground.player.centerX+(stageOneView.drawingThread.ground.topleftPoint.x*-1), stageOneView.drawingThread.ground.player.centerY);
//                System.out.println(p);
//                if(stageOneView.drawingThread.ground.player.animChar==stageOneView.drawingThread.ground.player.still) {
//                    stageOneView.drawingThread.ground.fire(p);
//                }else if(stageOneView.drawingThread.ground.player.animChar==stageOneView.drawingThread.ground.player.upStill){
//                    stageOneView.drawingThread.ground.fireUp(p);
//                }
////                if(stageOneView.drawingThread.ground.enemy1.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy1.isDead();
////                    System.out.println("done 1");
////                }else if(stageOneView.drawingThread.ground.enemy2.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy2.isDead();
////                    System.out.println("done 2");
////                }else if(stageOneView.drawingThread.ground.enemy3.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy3.isDead();
////                    System.out.println("done 3");
////                }else if(stageOneView.drawingThread.ground.enemy4.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy4.isDead();
////                    System.out.println("done 4");
////                }else if(stageOneView.drawingThread.ground.enemy5.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy5.isDead();
////                    System.out.println("done 5");
////                }else if(stageOneView.drawingThread.ground.enemy6.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy6.isDead();
////                    System.out.println("done 6");
////                }else if(stageOneView.drawingThread.ground.enemy7.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy7.isDead();
////                    System.out.println("done 7");
////                }else if(stageOneView.drawingThread.ground.enemy8.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy8.isDead();
////                }else if(stageOneView.drawingThread.ground.enemy9.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy9.isDead();
////                }else if(stageOneView.drawingThread.ground.enemy10.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy10.isDead();
////                }else if(stageOneView.drawingThread.ground.enemy11.isInRange(p)){
////                    stageOneView.drawingThread.ground.enemy11.isDead();
////                }
//            }
//        });
    }

}
