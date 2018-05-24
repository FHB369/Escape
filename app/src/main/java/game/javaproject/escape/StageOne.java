package game.javaproject.escape;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class StageOne extends AppCompatActivity {

    private StageOneView stageOneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_stage_one);
        stageOneView=findViewById(R.id.stageOneView);

        Button up=findViewById(R.id.upore);
        Button down=findViewById(R.id.niche);
        Button left=findViewById(R.id.bam);
        Button right=findViewById(R.id.dan);

        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.animCharUp;
                    stageOneView.drawingThread.ground.startMovingPlayerToUp();
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.upStill;
                    stageOneView.drawingThread.ground.stopMovingPlayerUp();
                }

                return false;
            }
        });

       down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.animCharDown;
                    stageOneView.drawingThread.ground.startMovingPlayerToDown();
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.downStill;
                    stageOneView.drawingThread.ground.stopMovingPlayerDown();
                }

                return false;
            }
        });

        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.animCharBack;
                    stageOneView.drawingThread.ground.startMovingPlayerToLeft();
                    stageOneView.drawingThread.ground.startMovingToRight();
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.backStill;
                    stageOneView.drawingThread.ground.stopMovingPlayerLeft();
                    stageOneView.drawingThread.ground.stopMovingRight();
                }

                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.animCharFront;
                    stageOneView.drawingThread.ground.startMovingPlayerToRight();
                    stageOneView.drawingThread.ground.startMovingToLeft();
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    stageOneView.drawingThread.ground.player.animChar=stageOneView.drawingThread.ground.player.still;
                    stageOneView.drawingThread.ground.stopMovingPlayerRight();
                    stageOneView.drawingThread.ground.stopMovingLeft();
                }

                return false;
            }
        });

    }

}
