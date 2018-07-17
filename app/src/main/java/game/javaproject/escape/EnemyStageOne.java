package game.javaproject.escape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;

public class EnemyStageOne {

    ArrayList<Bitmap> animChar, fired, fired1, fired2, nfired;
    DrawingThread drawingThread;

    int centerX, centerY, fireCount,idd;

    Point topLeftPoint;

    public EnemyStageOne(DrawingThread drawingThread, Point topLeftPoint){
        this.drawingThread = drawingThread;
        this.fireCount = 0;
        animChar = new ArrayList<Bitmap>();
        fired = new ArrayList<Bitmap>();
        fired1 = new ArrayList<Bitmap>();
        fired2 = new ArrayList<Bitmap>();
        nfired = new ArrayList<Bitmap>();
        this.idd=0;

        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.enemy1);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 299*drawingThread.displayY/1080, 167*drawingThread.displayY/1080, true);
        nfired.add(tempBitmap);
        nfired.add(tempBitmap);
        nfired.add(tempBitmap);
        fired.add(tempBitmap);
        fired.add(tempBitmap);
        fired.add(tempBitmap);

        fired1.add(tempBitmap);
        fired1.add(tempBitmap);
        fired1.add(tempBitmap);

        fired2.add(tempBitmap);
        fired2.add(tempBitmap);
        fired2.add(tempBitmap);


        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.enemy_blast_1);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 299*drawingThread.displayY/1080, 167*drawingThread.displayY/1080, true);
        fired1.add(tempBitmap);
        fired1.add(tempBitmap);
        fired1.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.enemy_blast_2);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 299*drawingThread.displayY/1080, 167*drawingThread.displayY/1080, true);
        fired2.add(tempBitmap);
        fired2.add(tempBitmap);
        fired2.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.enemy2);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 299*drawingThread.displayY/1080, 167*drawingThread.displayY/1080, true);
        nfired.add(tempBitmap);
        nfired.add(tempBitmap);
        nfired.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.enemy_blast);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 299*drawingThread.displayY/1080, 167*drawingThread.displayY/1080, true);
        fired.add(tempBitmap);
        fired.add(tempBitmap);
        fired.add(tempBitmap);



        this.animChar = nfired;

        this.topLeftPoint = topLeftPoint;
        centerX = topLeftPoint.x+150*drawingThread.displayY/1080;
        centerY = topLeftPoint.y+84*drawingThread.displayY/1080;
    }

    public void updatetop(){
        centerX = topLeftPoint.x+150*drawingThread.displayY/1080;
        centerY = topLeftPoint.y+84*drawingThread.displayY/1080;
    }

    public boolean isTouched(Point point){
        if(this.fireCount<8 && point.x>=topLeftPoint.x && point.x<=topLeftPoint.x+299  &&  point.y>=topLeftPoint.y && point.y<=topLeftPoint.y+167*drawingThread.displayY/1080){
            return true;
        }else{
            return false;
        }
    }

    public boolean isInRange(Point point){
        if(this.idd==0 && topLeftPoint.x-point.x==(300*drawingThread.displayY)/1080 && point.y-topLeftPoint.y==(90*drawingThread.displayY)/1080){
            return true;
        }else {
            return false;
        }
    }

    public void isDead(){
        if(fireCount<2) {
            animChar=nfired;
        }else if(fireCount>=2 && fireCount<4){
            animChar=fired1;
        }else if(fireCount>=4 && fireCount<6){
            animChar=fired2;
        }else if(fireCount>=6 && fireCount<8){
            animChar=fired;
        }
    }

}
