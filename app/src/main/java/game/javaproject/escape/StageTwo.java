package game.javaproject.escape;

import android.annotation.TargetApi;
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

public class StageTwo extends AppCompatActivity {

    private StageTwoView stageTwoView;
    public static long ammo = 12;
    long st, fn;
    boolean we1=false,we2=false,we3=false,we4=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_stage_two);


        stageTwoView=findViewById(R.id.stageTwoView);

        final Button up=findViewById(R.id.upore);
        final Button down=findViewById(R.id.niche);
        final Button left=findViewById(R.id.bam);
        final Button right=findViewById(R.id.dan);
        final Button guli=findViewById(R.id.fire_button);
        final Button pause = findViewById(R.id.pause);
        final Button exit = findViewById(R.id.e_button);


        final RelativeLayout tt = findViewById(R.id.mora);

        final TextView textView=findViewById(R.id.ammo);
        textView.setText(new Integer((int)ammo).toString());

        pause.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                DrawingThreadTwo.pauseFlag=!DrawingThreadTwo.pauseFlag;
                if(DrawingThreadTwo.pauseFlag==true) {
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
                stageTwoView.drawingThread.stopThread();
                try {
                    Intent intent = new Intent(StageTwo.this, FirstSuccess.class);
                    startActivity(intent);
                    stageTwoView.drawingThread.start();
                    finish();
                }catch (Exception e){
                    int pid = android.os.Process.myPid();
                    android.os.Process.killProcess(pid);
                    finish();
                    System.exit(0);
                }
            }
        });

        if(!DrawingThreadTwo.pauseFlag) {



            up.setOnTouchListener(new View.OnTouchListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY>=((345*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY<=((708*stageTwoView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageTwo.this, SecondSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if(stageTwoView.drawingThread.ground.enemy1.fireCount<8 && stageTwoView.drawingThread.ground.enemy2.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((1613*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((278*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((1743*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((707*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy4.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2561*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((177*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((493*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy4.fireCount<8 && stageTwoView.drawingThread.ground.enemy5.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2565*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((525*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((827*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3056*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((374*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((676*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy8.fireCount<8 && stageTwoView.drawingThread.ground.enemy9.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((214*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((480*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy9.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((574*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((840*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy6.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2877*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((241*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((368*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy5.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2792*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((719*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3063*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((846*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy7.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3243*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((734*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3514*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((861*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy8.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3239*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((158*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3510*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((285*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }


                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.animCharUp;
                        stageTwoView.drawingThread.ground.startMovingPlayerToUp();


                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.upStill;
                        stageTwoView.drawingThread.ground.stopMovingPlayerUp();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
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

                    if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY>=((345*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY<=((708*stageTwoView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageTwo.this, SecondSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if(stageTwoView.drawingThread.ground.enemy1.fireCount<8 && stageTwoView.drawingThread.ground.enemy2.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((1613*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((278*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((1743*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((707*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy4.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2561*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((177*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((493*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy4.fireCount<8 && stageTwoView.drawingThread.ground.enemy5.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2565*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((525*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((827*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3056*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((374*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((676*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy8.fireCount<8 && stageTwoView.drawingThread.ground.enemy9.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((214*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((480*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy9.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((574*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((840*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy6.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2877*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((241*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((368*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy5.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2792*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((719*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3063*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((846*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy7.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3243*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((734*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3514*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((861*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy8.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3239*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((158*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3510*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((285*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.animCharDown;
                        stageTwoView.drawingThread.ground.startMovingPlayerToDown();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.downStill;
                        stageTwoView.drawingThread.ground.stopMovingPlayerDown();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
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

                    if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY>=((345*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY<=((708*stageTwoView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageTwo.this, SecondSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if(stageTwoView.drawingThread.ground.enemy1.fireCount<8 && stageTwoView.drawingThread.ground.enemy2.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((1613*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((278*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((1743*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((707*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy4.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2561*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((177*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((493*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy4.fireCount<8 && stageTwoView.drawingThread.ground.enemy5.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2565*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((525*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((827*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3056*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((374*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((676*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy8.fireCount<8 && stageTwoView.drawingThread.ground.enemy9.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((214*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((480*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy9.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((574*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((840*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy6.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2877*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((241*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((368*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy5.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2792*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((719*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3063*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((846*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy7.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3243*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((734*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3514*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((861*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy8.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3239*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((158*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3510*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((285*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.animCharBack;
                        stageTwoView.drawingThread.ground.startMovingPlayerToLeft();
                        stageTwoView.drawingThread.ground.startMovingToRight();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.backStill;
                        stageTwoView.drawingThread.ground.stopMovingPlayerLeft();
                        stageTwoView.drawingThread.ground.stopMovingRight();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
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

                    if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY>=((345*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY<=((708*stageTwoView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageTwo.this, SecondSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if(stageTwoView.drawingThread.ground.enemy1.fireCount<8 && stageTwoView.drawingThread.ground.enemy2.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((1613*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((278*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((1743*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((707*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy4.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2561*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((177*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((493*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy4.fireCount<8 && stageTwoView.drawingThread.ground.enemy5.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2565*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((525*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((827*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3056*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((374*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((676*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy8.fireCount<8 && stageTwoView.drawingThread.ground.enemy9.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((214*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((480*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy9.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((574*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((840*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy6.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2877*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((241*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((368*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy5.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2792*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((719*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3063*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((846*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy7.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3243*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((734*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3514*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((861*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy8.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3239*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((158*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3510*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((285*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.animCharFront;
                        stageTwoView.drawingThread.ground.startMovingPlayerToRight();
                        stageTwoView.drawingThread.ground.startMovingToLeft();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        textView.setText(new Integer((int) ammo).toString());

                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.still;
                        stageTwoView.drawingThread.ground.stopMovingPlayerRight();
                        stageTwoView.drawingThread.ground.stopMovingLeft();

                        if (we1 == false && stageTwoView.drawingThread.ground.weapon1.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we1 = true;
                        }
                        if (we2 == false && stageTwoView.drawingThread.ground.weapon2.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we2 = true;
                        }
                        if (we3 == false && stageTwoView.drawingThread.ground.weapon3.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we3 = true;
                        }
                        if (we4 == false && stageTwoView.drawingThread.ground.weapon4.isGained(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            ammo += 30;
                            textView.setText(new Integer((int) ammo).toString());
                            we4 = true;
                        }
                        //System.out.println(stageTwoView.drawingThread.ground.player.centerX+" "+stageTwoView.drawingThread.ground.player.centerX);

                        if (stageTwoView.drawingThread.ground.enemy1.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy2.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy3.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy4.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy5.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy6.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy7.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy8.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy9.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy10.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
                            tt.setBackground(getDrawable(R.drawable.transparent));
                            ammo = 0;
                            we1 = we2 = we3 = we4 = false;
                        }
                        if (stageTwoView.drawingThread.ground.enemy11.isTouched(new Point(stageTwoView.drawingThread.ground.player.centerX, stageTwoView.drawingThread.ground.player.centerY))) {
                            tt.setBackground(getDrawable(R.drawable.dead));
                            stageTwoView.restartThread();
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
                    if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((4972*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY>=((345*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((5592*stageTwoView.drawingThread.displayY)/1080) &&
                            stageTwoView.drawingThread.ground.player.centerY<=((708*stageTwoView.drawingThread.displayY)/1080)){
                        Intent intent = new Intent(StageTwo.this, SecondSuccess.class);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        startActivity(intent);
                        finish();
                    }

                    if(stageTwoView.drawingThread.ground.enemy1.fireCount<8 && stageTwoView.drawingThread.ground.enemy2.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((1613*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((278*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((1743*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((707*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy4.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2561*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((177*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((493*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy4.fireCount<8 && stageTwoView.drawingThread.ground.enemy5.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2565*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((525*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((2657*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((827*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3056*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((374*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((676*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy8.fireCount<8 && stageTwoView.drawingThread.ground.enemy9.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((214*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((480*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy9.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3639*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((574*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3766*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((840*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy3.fireCount<8 && stageTwoView.drawingThread.ground.enemy6.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2877*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((241*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3148*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((368*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy5.fireCount<8 && stageTwoView.drawingThread.ground.enemy7.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((2792*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((719*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3063*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((846*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy7.fireCount<8 && stageTwoView.drawingThread.ground.enemy10.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3243*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((734*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3514*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((861*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }
                    if(stageTwoView.drawingThread.ground.enemy6.fireCount<8 && stageTwoView.drawingThread.ground.enemy8.fireCount<8){
                        if(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)>=((3239*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY>=((158*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1)<=((3510*stageTwoView.drawingThread.displayY)/1080) &&
                                stageTwoView.drawingThread.ground.player.centerY<=((285*stageTwoView.drawingThread.displayY)/1080)){
                            stageTwoView.restartThread();
                            ammo = 0;
                        }
                    }

                    if (ammo > 0) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                guli.setBackground(getDrawable(R.drawable.fire));
                            }
                            st = event.getEventTime();
                            Point p = new Point(stageTwoView.drawingThread.ground.player.centerX + (stageTwoView.drawingThread.ground.topleftPoint.x * -1), stageTwoView.drawingThread.ground.player.centerY);

                            if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.still) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.stillFire;
                                stageTwoView.drawingThread.ground.startFire(p);
                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.backStill) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.backStillFire;

                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.upStill) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.upFire;
                                stageTwoView.drawingThread.ground.fireUp(p);
                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.downStill) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.downFire;
                                stageTwoView.drawingThread.ground.fireDown(p);
                            }
                            textView.setText(new Integer((int) ammo).toString());

                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                guli.setBackground(getDrawable(R.drawable.fire1));
                            }
                            stageTwoView.drawingThread.ground.stopFire();
                            fn = event.getEventTime();

                            ammo = ammo - ((fn - st) * 10) / 1000;
                            if (ammo < 0) {
                                ammo = 0;
                            }

                            if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.stillFire) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.still;
                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.backStillFire) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.backStill;
                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.upFire) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.upStill;
                            } else if (stageTwoView.drawingThread.ground.player.animChar == stageTwoView.drawingThread.ground.player.downFire) {
                                stageTwoView.drawingThread.ground.player.animChar = stageTwoView.drawingThread.ground.player.downStill;
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
//                Point p = new Point(stageTwoView.drawingThread.ground.player.centerX+(stageTwoView.drawingThread.ground.topleftPoint.x*-1), stageTwoView.drawingThread.ground.player.centerY);
//                System.out.println(p);
//                if(stageTwoView.drawingThread.ground.player.animChar==stageTwoView.drawingThread.ground.player.still) {
//                    stageTwoView.drawingThread.ground.fire(p);
//                }else if(stageTwoView.drawingThread.ground.player.animChar==stageTwoView.drawingThread.ground.player.upStill){
//                    stageTwoView.drawingThread.ground.fireUp(p);
//                }
////                if(stageTwoView.drawingThread.ground.enemy1.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy1.isDead();
////                    System.out.println("done 1");
////                }else if(stageTwoView.drawingThread.ground.enemy2.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy2.isDead();
////                    System.out.println("done 2");
////                }else if(stageTwoView.drawingThread.ground.enemy3.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy3.isDead();
////                    System.out.println("done 3");
////                }else if(stageTwoView.drawingThread.ground.enemy4.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy4.isDead();
////                    System.out.println("done 4");
////                }else if(stageTwoView.drawingThread.ground.enemy5.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy5.isDead();
////                    System.out.println("done 5");
////                }else if(stageTwoView.drawingThread.ground.enemy6.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy6.isDead();
////                    System.out.println("done 6");
////                }else if(stageTwoView.drawingThread.ground.enemy7.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy7.isDead();
////                    System.out.println("done 7");
////                }else if(stageTwoView.drawingThread.ground.enemy8.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy8.isDead();
////                }else if(stageTwoView.drawingThread.ground.enemy9.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy9.isDead();
////                }else if(stageTwoView.drawingThread.ground.enemy10.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy10.isDead();
////                }else if(stageTwoView.drawingThread.ground.enemy11.isInRange(p)){
////                    stageTwoView.drawingThread.ground.enemy11.isDead();
////                }
//            }
//        });
    }
}
