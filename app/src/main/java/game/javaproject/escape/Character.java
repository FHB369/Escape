package game.javaproject.escape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class Character {
    ArrayList<Bitmap> animChar, animCharFront,animCharBack, animCharUp, animCharDown,still,backStill,upStill,downStill;
    Bitmap bitmap;
    DrawingThread drawingThread;

    int centerX, centerY, idx;

    Ground ground;

    Point topLeftPoint = new Point(0, 0);


    public Character(DrawingThread drawingThread) {
        this.drawingThread = drawingThread;

        animChar=new ArrayList<Bitmap>();
        animCharFront=new ArrayList<Bitmap>();
        animCharBack=new ArrayList<Bitmap>();
        animCharUp=new ArrayList<Bitmap>();
        animCharDown=new ArrayList<Bitmap>();
        still=new ArrayList<Bitmap>();
        backStill=new ArrayList<Bitmap>();
        upStill = new ArrayList<Bitmap>();
        downStill = new ArrayList<Bitmap>();

        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player2);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player3);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player4);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player11);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player22);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player33);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player44);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player111);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player222);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player333);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player444);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1111);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player2222);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player3333);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player4444);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);

        animChar = still;

        centerX=43*drawingThread.displayY/72;
        centerY=37*drawingThread.displayY/108;

        topLeftPoint.x=centerX-41*drawingThread.displayY/360;
        topLeftPoint.y=centerY-25*drawingThread.displayY/108;


    }

    public void update(){
        topLeftPoint.x=centerX-41*drawingThread.displayY/360;
        topLeftPoint.y=centerY-25*drawingThread.displayY/108;
    }

    public void updateTop(){
        centerX=topLeftPoint.x+41*drawingThread.displayY/360;
        centerY=topLeftPoint.y+25*drawingThread.displayY/108;
    }



}
