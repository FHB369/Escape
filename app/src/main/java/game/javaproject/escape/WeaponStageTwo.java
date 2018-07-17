package game.javaproject.escape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;

public class WeaponStageTwo {
    ArrayList<Bitmap> animChar;
    DrawingThreadTwo drawingThread;

    int centerX, centerY, idd;

    Point topLeftPoint;

    public WeaponStageTwo(DrawingThreadTwo drawingThread, Point topLeftPoint){
        this.drawingThread = drawingThread;
        idd=0;
        animChar = new ArrayList<Bitmap>();

        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.weapon);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 90*drawingThread.displayY/1080, 90*drawingThread.displayY/1080, true);
        animChar.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.transparent);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, 90*drawingThread.displayY/1080, 90*drawingThread.displayY/1080, true);
        animChar.add(tempBitmap);

        this.topLeftPoint = topLeftPoint;
        centerX = topLeftPoint.x+45*drawingThread.displayY/1080;
        centerY = topLeftPoint.y+45*drawingThread.displayY/1080;
    }

    public void updatetop(){
        centerX = topLeftPoint.x+45*drawingThread.displayY/1080;
        centerY = topLeftPoint.y+45*drawingThread.displayY/1080;
    }

    public boolean gained(Point centerPoint){
        if(centerPoint.x>=topLeftPoint.x && centerPoint.x<=topLeftPoint.x+90*drawingThread.displayY/1080  &&  centerPoint.y>=topLeftPoint.y && centerPoint.y<=topLeftPoint.y+70*drawingThread.displayY/1080){
            this.idd=1;
            return false;
        }else{
            return true;
        }
    }

    public boolean isGained(Point centerPoint){
        if(centerPoint.x>=topLeftPoint.x && centerPoint.x<=topLeftPoint.x+90*drawingThread.displayY/1080  &&  centerPoint.y>=topLeftPoint.y && centerPoint.y<=topLeftPoint.y+70*drawingThread.displayY/1080){
            return true;
        }else{
            return false;
        }
    }
}
