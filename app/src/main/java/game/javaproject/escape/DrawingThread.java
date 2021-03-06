package game.javaproject.escape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;

public class DrawingThread extends Thread {

    private Canvas canvas;
    StageOneView stageOneView;
    Context context;
    public static boolean pauseFlag = false;

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
    int idd=0;

    private void updateDisplay() {
        canvas.drawBitmap(ground.groundBitmap, ground.topleftPoint.x, ground.topleftPoint.y, null);

        if(ground.enemy1.fireCount<8)canvas.drawBitmap(ground.enemy1.animChar.get(idd), ground.enemy1.topLeftPoint.x, ground.enemy1.topLeftPoint.y, null);
        if(ground.enemy2.fireCount<8)canvas.drawBitmap(ground.enemy2.animChar.get(idd), ground.enemy2.topLeftPoint.x, ground.enemy2.topLeftPoint.y, null);
        if(ground.enemy3.fireCount<8)canvas.drawBitmap(ground.enemy3.animChar.get(idd), ground.enemy3.topLeftPoint.x, ground.enemy3.topLeftPoint.y, null);
        if(ground.enemy4.fireCount<8)canvas.drawBitmap(ground.enemy4.animChar.get(idd), ground.enemy4.topLeftPoint.x, ground.enemy4.topLeftPoint.y, null);
        if(ground.enemy5.fireCount<8)canvas.drawBitmap(ground.enemy5.animChar.get(idd), ground.enemy5.topLeftPoint.x, ground.enemy5.topLeftPoint.y, null);
        if(ground.enemy6.fireCount<8)canvas.drawBitmap(ground.enemy6.animChar.get(idd), ground.enemy6.topLeftPoint.x, ground.enemy6.topLeftPoint.y, null);
        if(ground.enemy7.fireCount<8)canvas.drawBitmap(ground.enemy7.animChar.get(idd), ground.enemy7.topLeftPoint.x, ground.enemy7.topLeftPoint.y, null);
        if(ground.enemy8.fireCount<8)canvas.drawBitmap(ground.enemy8.animChar.get(idd), ground.enemy8.topLeftPoint.x, ground.enemy8.topLeftPoint.y, null);
        if(ground.enemy9.fireCount<8)canvas.drawBitmap(ground.enemy9.animChar.get(idd), ground.enemy9.topLeftPoint.x, ground.enemy9.topLeftPoint.y, null);
        if(ground.enemy10.fireCount<8)canvas.drawBitmap(ground.enemy10.animChar.get(idd), ground.enemy10.topLeftPoint.x, ground.enemy10.topLeftPoint.y, null);
        if(ground.enemy11.fireCount<8)canvas.drawBitmap(ground.enemy11.animChar.get(idd), ground.enemy11.topLeftPoint.x, ground.enemy11.topLeftPoint.y, null);

        if(ground.weapon1.gained(new Point(ground.player.centerX, ground.player.centerY))){canvas.drawBitmap(ground.weapon1.animChar.get(ground.weapon1.idd), ground.weapon1.topLeftPoint.x, ground.weapon1.topLeftPoint.y, null);}
        if(ground.weapon2.gained(new Point(ground.player.centerX, ground.player.centerY))){canvas.drawBitmap(ground.weapon2.animChar.get(ground.weapon2.idd), ground.weapon2.topLeftPoint.x, ground.weapon2.topLeftPoint.y, null);}
        if(ground.weapon3.gained(new Point(ground.player.centerX, ground.player.centerY))){canvas.drawBitmap(ground.weapon3.animChar.get(ground.weapon3.idd), ground.weapon3.topLeftPoint.x, ground.weapon3.topLeftPoint.y, null);}
        if(ground.weapon4.gained(new Point(ground.player.centerX, ground.player.centerY))){canvas.drawBitmap(ground.weapon4.animChar.get(ground.weapon4.idd), ground.weapon4.topLeftPoint.x, ground.weapon4.topLeftPoint.y, null);}


        canvas.drawBitmap(ground.player.animChar.get(index), ground.player.topLeftPoint.x, ground.player.topLeftPoint.y, null);
        canvas.drawBitmap(cloud.groundBitmap, cloud.topleftPoint.x, cloud.topleftPoint.y, null);

        if(pauseFlag){
            pauseStateDraw();
        }

        index++;
        index=index%4;
        idd++;
        idd=idd%6;

    }

    private void pauseStateDraw() {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawARGB(170,0,0,0);
        canvas.drawText("Paused", displayX/2,displayY/2,paint);
    }


    public void stopThread(){
        threadFlag = false;
    }
}
