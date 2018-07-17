package game.javaproject.escape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;

public class CharacterTwo {

    ArrayList<Bitmap> animChar, animCharFront,animCharBack, animCharUp, animCharDown,still,backStill,upStill,downStill,upFire, downFire, stillFire, backStillFire;
    Bitmap bitmap;
    DrawingThreadTwo drawingThread;

    public int centerX, centerY, idx;

    GroundTwo ground;

    Point topLeftPoint = new Point(0, 0);


    public CharacterTwo(DrawingThreadTwo drawingThread) {        this.drawingThread = drawingThread;

        animChar=new ArrayList<Bitmap>();
        animCharFront=new ArrayList<Bitmap>();
        animCharBack=new ArrayList<Bitmap>();
        animCharUp=new ArrayList<Bitmap>();
        animCharDown=new ArrayList<Bitmap>();
        still=new ArrayList<Bitmap>();
        backStill=new ArrayList<Bitmap>();
        upStill = new ArrayList<Bitmap>();
        downFire = new ArrayList<Bitmap>();
        upFire = new ArrayList<Bitmap>();
        stillFire = new ArrayList<Bitmap>();
        backStillFire = new ArrayList<Bitmap>();
        downStill = new ArrayList<Bitmap>();


        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);
        still.add(tempBitmap);
        stillFire.add(tempBitmap);
        stillFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1firew);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        stillFire.add(tempBitmap);
        stillFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player2w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player3w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player4w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharFront.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player11w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);
        backStill.add(tempBitmap);
        backStillFire.add(tempBitmap);
        backStillFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player11firew);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        backStillFire.add(tempBitmap);
        backStillFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player22w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player33w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player44w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharBack.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player111w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);
        upStill.add(tempBitmap);
        upFire.add(tempBitmap);
        upFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player111firew);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        upFire.add(tempBitmap);
        upFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player222w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player333w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player444w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharUp.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1111w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);
        downStill.add(tempBitmap);
        downFire.add(tempBitmap);
        downFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player1111firew);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        downFire.add(tempBitmap);
        downFire.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player2222w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player3333w);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap,133*drawingThread.displayY/540, 133*drawingThread.displayY/540, true);
        animCharDown.add(tempBitmap);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.player4444w);
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
