package game.javaproject.escape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;

public class DrawingThread extends Thread {

    private Canvas canvas;
    StageOneView stageOneView;
    Context context;

    boolean threadFlag = false;

    public ArrayList<Point> swipe = new ArrayList<Point>();

    Ground ground;
    Ground cloud;

    int displayX, displayY;

    public DrawingThread(StageOneView stageOneView, Context context) {
        this.stageOneView = stageOneView;
        this.context = context;

        initializeAll();
    }

    private void initializeAll() {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point displayDimension  = new Point();
        defaultDisplay.getSize(displayDimension);

        displayX = displayDimension.x;
        displayY = displayDimension.y;

        ground = new Ground(this, R.drawable.stage1,4);
        cloud = new Ground(this, R.drawable.cloud,2);


    }

    int timer = 16;

    @Override
    public void run() {
        super.run();
        threadFlag = true;
        while(threadFlag){
            canvas = stageOneView.surfaceHolder.lockCanvas();
            try{
                synchronized (stageOneView.surfaceHolder){
                    updateDisplay();
                    //animate();
                }
            }catch(Exception e){

            }finally {
                if(canvas!=null){
                    stageOneView.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            try {
                sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    int index=0;

    private void updateDisplay() {
        canvas.drawBitmap(ground.groundBitmap, ground.topleftPoint.x, ground.topleftPoint.y, null);
        canvas.drawBitmap(ground.player.animChar.get(index), ground.player.topLeftPoint.x, ground.player.topLeftPoint.y, null);
        canvas.drawBitmap(cloud.groundBitmap, cloud.topleftPoint.x, cloud.topleftPoint.y, null);

        index++;
        index=index%4;

    }



    public void stopThread(){
        threadFlag = false;
    }
}
