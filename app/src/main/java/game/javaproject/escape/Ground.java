package game.javaproject.escape;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;

import java.util.HashMap;
import java.util.Map;

public class Ground {

    Bitmap groundBitmap, tBitmap;
    int groundWidth, groundHeight;
    int leftmostPoint, rightmostPoint;
    int val;

    Point topleftPoint = new Point(0,0);
    DrawingThread drawingThread;

    boolean movingLeft = false;
    boolean movingRight = false;
    int start,finish;

    Character player;

    public Ground(DrawingThread drawingThread, int bitmapID, int val) {
        this.drawingThread = drawingThread;
        this.val = val;
        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), bitmapID);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, drawingThread.displayY * tempBitmap.getWidth() / tempBitmap.getHeight(), drawingThread.displayY, true);

        groundBitmap = tempBitmap;

        groundHeight = groundBitmap.getHeight();
        groundWidth = groundBitmap.getWidth();

        player=new Character(drawingThread);

    }

    public void moveLeft(){
        if((-1*topleftPoint.x)+drawingThread.displayX<=groundWidth-2){
            topleftPoint.x-=val;
            player.topLeftPoint.x-=val;
            player.updateTop();
        }
    }

    public void moveRight(){
        if(topleftPoint.x<=-2){
            topleftPoint.x+=val;
            player.topLeftPoint.x+=val;
            player.updateTop();
        }
    }

    public void startMovingToLeft(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                movingLeft=true;

                while(movingLeft){
                    moveLeft();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public void stopMovingLeft(){
        movingLeft=false;
    }


    public void startMovingToRight(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                movingRight=true;

                while(movingRight){
                    moveRight();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public void stopMovingRight(){
        movingRight=false;
    }




    public void movePlayerLeft(){
        if(obstacleTrace(new Point(player.centerX-4,player.centerY))){
            player.topLeftPoint.x-=4;
            player.updateTop();
        }
    }
    public void movePlayerRight(){
        if(obstacleTrace(new Point(player.centerX+4,player.centerY))){
            player.topLeftPoint.x+=4;
            player.updateTop();
        }
    }
    public void movePlayerUp(){
        if(obstacleTrace(new Point(player.centerX,player.centerY-4))){
            player.topLeftPoint.y-=4;
            player.updateTop();
        }
    }
    public void movePlayerDown(){
        if(obstacleTrace(new Point(player.centerX,player.centerY+4))){
            player.topLeftPoint.y+=4;
            player.updateTop();
        }
    }

    boolean playerMovingRight=false, playerMovingLeft=false, playerMovingUp=false, playerMovingDown=false;

    public void startMovingPlayerToRight(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                playerMovingRight=true;

                while(playerMovingRight){
                    movePlayerRight();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    public void startMovingPlayerToLeft(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                playerMovingLeft=true;

                while(playerMovingLeft){
                    movePlayerLeft();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    public void startMovingPlayerToUp(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                playerMovingUp=true;

                while(playerMovingUp){
                    movePlayerUp();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    public void startMovingPlayerToDown(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                playerMovingDown=true;

                while(playerMovingDown){
                    movePlayerDown();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public void stopMovingPlayerRight(){
        playerMovingRight=false;
    }
    public void stopMovingPlayerLeft(){
        playerMovingLeft=false;
    }
    public void stopMovingPlayerUp(){
        playerMovingUp=false;
    }
    public void stopMovingPlayerDown(){
        playerMovingDown=false;
    }



    public boolean obstacleTrace(Point point){
        int x=point.x;
        int y=point.y;
        x=x+(-1*topleftPoint.x);
        x=x*5759/groundWidth;
        y=y*1080/groundHeight;




        if(x>=1090 && x<=1730 && y>=130 && y<=210)return false;
        else if(x>=810 && x<=1660 && y>=280 && y<=360)return false;
        else if(x>=3650 && x<=3940 && y>=400 && y<=480)return false;
        else if(x>=3420 && x<=3870 && y>=520 && y<=600)return false;
        else if(x>=3420 && x<=3520 && y>=300 && y<=520)return false;
        else if(x>=3050 && x<=3250 && y>=420 && y<=704)return false;
        else if(x>=1880 && x<=2620 && y>=280 && y<=620)return false;
        else if(x>=1500 && x<=3150 && y>=420 && y<=500)return false;
        else if(x>=1470 && x<=2920 && y>=2500 && y<=620)return false;
        else if(x>=1650 && x<=1900 && y>=270 && y<=320)return false;
        else if(x>=1800 && x<=1960 && y>=320 && y<=360)return false;
        else if(x>=710 && x<=910 && y>=420 && y<=520)return false;
        else if(x>=670 && x<=850 && y>=490 && y<=610)return false;
        else if(x>=640 && x<=820 && y>=560 && y<=690)return false;
        else if(x>=570 && x<=770 && y>=680 && y<=810)return false;
        else if(x>=1020 && x<=1390 && y>=420 && y<=610)return false;
        else if(x>=960 && x<=1190 && y>=590 && y<=720)return false;
        else if(x>=3940 && x<=4560 && y>=400 && y<=700)return false;
        else if(x>=460 && x<=1040 && y<=210 )return false;
        else if(x>=1040 && x<=1800 && y<=90 )return false;
        else if(x>=1800 && x<=5140 && y<=210 )return false;
        else if(x>=900 && y>=700 && y<=800 )return false;
        else if(x>=2800 && y>=270 && y<=360 )return false;
        else if(x>=5140 &&  y<=800 )return false;
        else if(x<=460 )return false;
        else if(y>=890 )return false;
        else if(x>=5480 )return false;

        else {
            return true;
        }
    }



}
