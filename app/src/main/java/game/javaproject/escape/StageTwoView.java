package game.javaproject.escape;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StageTwoView extends SurfaceView implements SurfaceHolder.Callback{

    Context context;
    DrawingThreadTwo drawingThread;
    SurfaceHolder surfaceHolder;
    public Point touchPoint;


    public StageTwoView(Context context) {
        super(context);
        this.context=context;

        Log.i("bappy","started 0");

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        drawingThread  = new DrawingThreadTwo(this, context);
        touchPoint=new Point();
    }

    public StageTwoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;

        Log.i("bappy","started 1");

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        drawingThread  = new DrawingThreadTwo(this, context);
        touchPoint=new Point();

    }

    public StageTwoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;

        Log.i("bappy","started 2");

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        drawingThread  = new DrawingThreadTwo(this, context);
        touchPoint=new Point();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StageTwoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context=context;

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        drawingThread  = new DrawingThreadTwo(this, context);
        touchPoint=new Point();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Log.i("bappy","End");

        try{
            drawingThread.start();
        }catch (Exception e){
            Log.i("bappy","Error");
            restartThread();
        }
    }

    public void restartThread() {
        drawingThread.stopThread();
        drawingThread = null;
        drawingThread = new DrawingThreadTwo(this, context);
        drawingThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawingThread.stopThread();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchPoint.x=(int)event.getX();
        touchPoint.y=(int)event.getY();

//        drawingThread.ground.player.centerX=touchPoint.x;
//        drawingThread.ground.player.centerY=touchPoint.y;
//        drawingThread.ground.player.update();


        return super.onTouchEvent(event);
    }
}
