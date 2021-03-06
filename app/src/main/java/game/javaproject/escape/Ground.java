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
    boolean weaponFlag = false;
    boolean firing = false;
    boolean fir=false;
    int start,finish;
    public static int ammo=1;

    Character player;
    EnemyStageOne enemy1;
    EnemyStageOne enemy2;
    EnemyStageOne enemy3;
    EnemyStageOne enemy4;
    EnemyStageOne enemy5;
    EnemyStageOne enemy6;
    EnemyStageOne enemy7;
    EnemyStageOne enemy8;
    EnemyStageOne enemy9;
    EnemyStageOne enemy10;
    EnemyStageOne enemy11;

    WeaponStageOne weapon1;
    WeaponStageOne weapon2;
    WeaponStageOne weapon3;
    WeaponStageOne weapon4;



    public Ground(DrawingThread drawingThread, int bitmapID, int val) {
        this.drawingThread = drawingThread;
        this.val = val;
        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), bitmapID);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, drawingThread.displayY * tempBitmap.getWidth() / tempBitmap.getHeight(), drawingThread.displayY, true);

        groundBitmap = tempBitmap;

        groundHeight = groundBitmap.getHeight();
        groundWidth = groundBitmap.getWidth();

        player=new Character(drawingThread);
        Point enemyOne = new Point(893*drawingThread.displayY/1080, 126*drawingThread.displayY/1080);
        Point enemyTwo = new Point(1555*drawingThread.displayY/1080, 775*drawingThread.displayY/1080);
        Point enemyThree = new Point(1880*drawingThread.displayY/1080, 562*drawingThread.displayY/1080);
        Point enemyFour = new Point(2731*drawingThread.displayY/1080, 118*drawingThread.displayY/1080);
        Point enemyFive = new Point(2845*drawingThread.displayY/1080, 562*drawingThread.displayY/1080);
        Point enemySix = new Point(3151*drawingThread.displayY/1080, 309*drawingThread.displayY/1080);
        Point enemySeven = new Point(3264*drawingThread.displayY/1080, 780*drawingThread.displayY/1080);
        Point enemyEight = new Point(3717*drawingThread.displayY/1080, 423*drawingThread.displayY/1080);
        Point enemyNine = new Point(4474*drawingThread.displayY/1080, 562*drawingThread.displayY/1080);
        Point enemyTen = new Point(4752*drawingThread.displayY/1080, 363*drawingThread.displayY/1080);
        Point enemyEleven = new Point(4980*drawingThread.displayY/1080, 793*drawingThread.displayY/1080);

        Point weaponOne = new Point(1163*drawingThread.displayY/1080, 631*drawingThread.displayY/1080);
        Point weaponTwo = new Point(1723*drawingThread.displayY/1080, 187*drawingThread.displayY/1080);
        Point weaponThree = new Point(2171*drawingThread.displayY/1080, 507*drawingThread.displayY/1080);
        Point weaponFour = new Point(3371*drawingThread.displayY/1080, 623*drawingThread.displayY/1080);

        enemy1=new EnemyStageOne(drawingThread, enemyOne);
        enemy2=new EnemyStageOne(drawingThread, enemyTwo);
        enemy3=new EnemyStageOne(drawingThread, enemyThree);
        enemy4=new EnemyStageOne(drawingThread, enemyFour);
        enemy5=new EnemyStageOne(drawingThread, enemyFive);
        enemy6=new EnemyStageOne(drawingThread, enemySix);
        enemy7=new EnemyStageOne(drawingThread, enemySeven);
        enemy8=new EnemyStageOne(drawingThread, enemyEight);
        enemy9=new EnemyStageOne(drawingThread, enemyNine);
        enemy10=new EnemyStageOne(drawingThread, enemyTen);
        enemy11=new EnemyStageOne(drawingThread, enemyEleven);

        weapon1=new WeaponStageOne(drawingThread, weaponOne);
        weapon2=new WeaponStageOne(drawingThread, weaponTwo);
        weapon3=new WeaponStageOne(drawingThread, weaponThree);
        weapon4=new WeaponStageOne(drawingThread, weaponFour);

    }

    public void fire(Point p){

        if(p.x>=(532*drawingThread.displayY)/1080 && p.x<=(918*drawingThread.displayY)/1080  &&  p.y>=(193*drawingThread.displayY)/1080 && p.y<=(279*drawingThread.displayY)/1080){
            enemy1.fireCount+=1;
            enemy1.isDead();
        }else if(p.x>=(918*drawingThread.displayY)/1080 && p.x<=(1591*drawingThread.displayY)/1080  &&  p.y>=(809*drawingThread.displayY)/1080 && p.y<=(918*drawingThread.displayY)/1080){
            enemy2.fireCount+=1;
            enemy2.isDead();
        }else if(p.x>=(1255*drawingThread.displayY)/1080 && p.x<=(1961*drawingThread.displayY)/1080  &&  p.y>=(608*drawingThread.displayY)/1080 && p.y<=(717*drawingThread.displayY)/1080){
            enemy3.fireCount+=1;
            enemy3.isDead();
        }else if(p.x>=(2105*drawingThread.displayY)/1080 && p.x<=(2766*drawingThread.displayY)/1080  &&  p.y>=(170*drawingThread.displayY)/1080 && p.y<=(279*drawingThread.displayY)/1080){
            enemy4.fireCount+=1;
            enemy4.isDead();
        }else if(p.x>=(2143*drawingThread.displayY)/1080 && p.x<=(2880*drawingThread.displayY)/1080  &&  p.y>=(608*drawingThread.displayY)/1080 && p.y<=(717*drawingThread.displayY)/1080){
            enemy5.fireCount+=1;
            enemy5.isDead();
        }else if(p.x>=(2624*drawingThread.displayY)/1080 && p.x<=(3185*drawingThread.displayY)/1080  &&  p.y>=(352*drawingThread.displayY)/1080 && p.y<=(447*drawingThread.displayY)/1080){
            enemy6.fireCount+=1;
            enemy6.isDead();
        }else if(p.x>=(2436*drawingThread.displayY)/1080 && p.x<=(3300*drawingThread.displayY)/1080  &&  p.y>=(809*drawingThread.displayY)/1080 && p.y<=(938*drawingThread.displayY)/1080){
            enemy7.fireCount+=1;
            enemy7.isDead();
        }else if(p.x>=(4204*drawingThread.displayY)/1080 && p.x<=(5032*drawingThread.displayY)/1080  &&  p.y>=(809*drawingThread.displayY)/1080 && p.y<=(938*drawingThread.displayY)/1080){
            enemy11.fireCount+=1;
            enemy11.isDead();
        }else if(p.x>=(4337*drawingThread.displayY)/1080 && p.x<=(4752*drawingThread.displayY)/1080  &&  p.y>=(347*drawingThread.displayY)/1080 && p.y<=(463*drawingThread.displayY)/1080){
            enemy10.fireCount+=1;
            enemy10.isDead();
        }
    }

    public void fireUp(Point p){
        if(p.x>=(3842*drawingThread.displayY)/1080 && p.x<=(3992*drawingThread.displayY)/1080  &&  p.y>=(562*drawingThread.displayY)/1080 && p.y<=(717*drawingThread.displayY)/1080){
            enemy8.fireCount+=3;

            enemy8.isDead();
        }
    }

    public void fireDown(Point p){
        if(p.x>=(4506*drawingThread.displayY)/1080 && p.x<=(4740*drawingThread.displayY)/1080  &&  p.y>=(363*drawingThread.displayY)/1080 && p.y<=(615*drawingThread.displayY)/1080){
            enemy9.fireCount+=3;

            enemy9.isDead();
        }
    }




    public void startFire(final Point p){
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                firing=true;

                while(firing){
                    fire(p);
                    try {
                        sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }



    public void stopFire(){
        firing=false;
    }

    public void moveLeft(){
        if((-1*topleftPoint.x)+drawingThread.displayX<=groundWidth-2){
            topleftPoint.x-=val;
            player.topLeftPoint.x-=val;
            player.updateTop();

            enemy1.topLeftPoint.x-=val;
            enemy2.topLeftPoint.x-=val;
            enemy3.topLeftPoint.x-=val;
            enemy4.topLeftPoint.x-=val;
            enemy5.topLeftPoint.x-=val;
            enemy6.topLeftPoint.x-=val;
            enemy7.topLeftPoint.x-=val;
            enemy8.topLeftPoint.x-=val;
            enemy9.topLeftPoint.x-=val;
            enemy10.topLeftPoint.x-=val;
            enemy11.topLeftPoint.x-=val;

            enemy1.updatetop();
            enemy2.updatetop();
            enemy3.updatetop();
            enemy4.updatetop();
            enemy5.updatetop();
            enemy6.updatetop();
            enemy7.updatetop();
            enemy8.updatetop();
            enemy9.updatetop();
            enemy10.updatetop();
            enemy11.updatetop();

            weapon1.topLeftPoint.x-=val;
            weapon2.topLeftPoint.x-=val;
            weapon3.topLeftPoint.x-=val;
            weapon4.topLeftPoint.x-=val;

            weapon1.updatetop();
            weapon2.updatetop();
            weapon3.updatetop();
            weapon4.updatetop();
        }
    }

    public void moveRight(){
        if(topleftPoint.x<=-2){
            topleftPoint.x+=val;
            player.topLeftPoint.x+=val;
            player.updateTop();

            enemy1.topLeftPoint.x+=val;
            enemy2.topLeftPoint.x+=val;
            enemy3.topLeftPoint.x+=val;
            enemy4.topLeftPoint.x+=val;
            enemy5.topLeftPoint.x+=val;
            enemy6.topLeftPoint.x+=val;
            enemy7.topLeftPoint.x+=val;
            enemy8.topLeftPoint.x+=val;
            enemy9.topLeftPoint.x+=val;
            enemy10.topLeftPoint.x+=val;
            enemy11.topLeftPoint.x+=val;

            enemy1.updatetop();
            enemy2.updatetop();
            enemy3.updatetop();
            enemy4.updatetop();
            enemy5.updatetop();
            enemy6.updatetop();
            enemy7.updatetop();
            enemy8.updatetop();
            enemy9.updatetop();
            enemy10.updatetop();
            enemy11.updatetop();

            weapon1.topLeftPoint.x+=val;
            weapon2.topLeftPoint.x+=val;
            weapon3.topLeftPoint.x+=val;
            weapon4.topLeftPoint.x+=val;

            weapon1.updatetop();
            weapon2.updatetop();
            weapon3.updatetop();
            weapon4.updatetop();
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
        else if(x>=1880 && x<=2620 && y>=280 && y<=480)return false;
        else if(x>=1500 && x<=3150 && y>=420 && y<=500)return false;
        else if(x>=1470 && x<=2114 && y>=420 && y<=620)return false;
        else if(x>=2302 && x<=2918 && y>=420 && y<=620)return false;
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
