package game.javaproject.escape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;

public class DrawingThreadTwo extends Thread {

    private Canvas canvas;
    StageTwoView stageTwoView;
    Context context;
    public static boolean pauseFlag = false;

    boolean threadFlag = false;

    public ArrayList<Point> swipe = new ArrayList<Point>();

    GroundTwo ground;
    GroundTwo cloud;

    int displayX, displayY;

    public DrawingThreadTwo(StageTwoView stageTwoView, Context context) {
        this.stageTwoView = stageTwoView;
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

        ground = new GroundTwo(this, R.drawable.stage2,4);
        cloud = new GroundTwo(this, R.drawable.cloud,2);


    }

    int timer = 16;

    @Override
    public void run() {
        super.run();
        threadFlag = true;
        while(threadFlag){
            canvas = stageTwoView.surfaceHolder.lockCanvas();
            try{
                synchronized (stageTwoView.surfaceHolder){
                    updateDisplay();
                    //animate();
                }
            }catch(Exception e){

            }finally {
                if(canvas!=null){
                    stageTwoView.surfaceHolder.unlockCanvasAndPost(canvas);
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

        if(ground.enemy1.fireCount<8 && ground.enemy3.fireCount<8)canvas.drawBitmap(ground.b1n2,ground.b12.x,ground.b12.y, null);
        if(ground.enemy3.fireCount<8 && ground.enemy4.fireCount<8)canvas.drawBitmap(ground.b3n4,ground.b34.x,ground.b34.y, null);
        if(ground.enemy4.fireCount<8 && ground.enemy5.fireCount<8)canvas.drawBitmap(ground.b4n5,ground.b45.x,ground.b45.y, null);
        if(ground.enemy6.fireCount<8 && ground.enemy7.fireCount<8)canvas.drawBitmap(ground.b6n7,ground.b67.x,ground.b67.y, null);
        if(ground.enemy8.fireCount<8 && ground.enemy9.fireCount<8)canvas.drawBitmap(ground.b8n9,ground.b89.x,ground.b89.y, null);
        if(ground.enemy9.fireCount<8 && ground.enemy10.fireCount<8)canvas.drawBitmap(ground.b9n10,ground.b910.x,ground.b910.y, null);
        if(ground.enemy3.fireCount<8 && ground.enemy6.fireCount<8)canvas.drawBitmap(ground.b3n6,ground.b36.x,ground.b36.y, null);
        if(ground.enemy5.fireCount<8 && ground.enemy7.fireCount<8)canvas.drawBitmap(ground.b5n7,ground.b57.x,ground.b57.y, null);
        if(ground.enemy6.fireCount<8 && ground.enemy8.fireCount<8)canvas.drawBitmap(ground.b6n8,ground.b68.x,ground.b68.y, null);
        if(ground.enemy7.fireCount<8 && ground.enemy10.fireCount<8)canvas.drawBitmap(ground.b7n10,ground.b710.x,ground.b710.y, null);

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
