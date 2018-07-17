package game.javaproject.escape;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class GroundTwo {
    Bitmap groundBitmap, tBitmap;
    int groundWidth, groundHeight;
    int leftmostPoint, rightmostPoint;
    int val;

    Point topleftPoint = new Point(0,0);
    DrawingThreadTwo drawingThread;

    boolean movingLeft = false;
    boolean movingRight = false;
    boolean weaponFlag = false;
    boolean firing = false;
    boolean fir=false;
    int start,finish;
    public static int ammo=1;

    CharacterTwo player;
    EnemyStageTwo enemy1;
    EnemyStageTwo enemy2;
    EnemyStageTwo enemy3;
    EnemyStageTwo enemy4;
    EnemyStageTwo enemy5;
    EnemyStageTwo enemy6;
    EnemyStageTwo enemy7;
    EnemyStageTwo enemy8;
    EnemyStageTwo enemy9;
    EnemyStageTwo enemy10;
    EnemyStageTwo enemy11;

    WeaponStageTwo weapon1;
    WeaponStageTwo weapon2;
    WeaponStageTwo weapon3;
    WeaponStageTwo weapon4;

    Bitmap b1n2, b3n4, b4n5, b6n7, b8n9, b9n10, b3n6, b5n7, b6n8, b7n10;
    Point b12,b34,b45,b67,b89,b910,b36,b57,b68,b710;



    public GroundTwo(DrawingThreadTwo drawingThread, int bitmapID, int val) {
        this.drawingThread = drawingThread;
        this.val = val;
        Bitmap tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), bitmapID);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, drawingThread.displayY * tempBitmap.getWidth() / tempBitmap.getHeight(), drawingThread.displayY, true);

        groundBitmap = tempBitmap;

        groundHeight = groundBitmap.getHeight();
        groundWidth = groundBitmap.getWidth();

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between1and2);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 130)/1080, (drawingThread.displayY*429)/1080, true);
        b1n2 = tempBitmap;
        b12 = new Point((1613*drawingThread.displayY)/1080, (278*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between3and4);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 130)/1080, (drawingThread.displayY*429)/1080, true);
        b3n4 = tempBitmap;
        b34 = new Point((2561*drawingThread.displayY)/1080, (177*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between4and5);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 130)/1080, (drawingThread.displayY*429)/1080, true);
        b4n5 = tempBitmap;
        b45 = new Point((2565*drawingThread.displayY)/1080, (525*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between6and7);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 130)/1080, (drawingThread.displayY*429)/1080, true);
        b6n7 = tempBitmap;
        b67 = new Point((3056*drawingThread.displayY)/1080, (374*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between8and9);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 171)/1080, (drawingThread.displayY*361)/1080, true);
        b8n9 = tempBitmap;
        b89 = new Point((3574*drawingThread.displayY)/1080, (168*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between9and10);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 225)/1080, (drawingThread.displayY*340)/1080, true);
        b9n10 = tempBitmap;
        b910 = new Point((3546*drawingThread.displayY)/1080, (545*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between3and6);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 338)/1080, (drawingThread.displayY*227)/1080, true);
        b3n6 = tempBitmap;
        b36 = new Point((2684*drawingThread.displayY)/1080, (149*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between5and7);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 398)/1080, (drawingThread.displayY*250)/1080, true);
        b5n7 = tempBitmap;
        b57 = new Point((2654*drawingThread.displayY)/1080, (667*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between6and8);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 345)/1080, (drawingThread.displayY*199)/1080, true);
        b6n8 = tempBitmap;
        b68 = new Point((3168*drawingThread.displayY)/1080, (142*drawingThread.displayY)/1080);

        tempBitmap = BitmapFactory.decodeResource(drawingThread.context.getResources(), R.drawable.between7and10);
        tempBitmap = Bitmap.createScaledBitmap(tempBitmap, (drawingThread.displayY * 350)/1080, (drawingThread.displayY*204)/1080, true);
        b7n10 = tempBitmap;
        b710 = new Point((3168*drawingThread.displayY)/1080, (681*drawingThread.displayY)/1080);

        player=new CharacterTwo(drawingThread);
        Point enemyOne = new Point(1525*drawingThread.displayY/1080, 157*drawingThread.displayY/1080);
        Point enemyTwo = new Point(1525*drawingThread.displayY/1080, 694*drawingThread.displayY/1080);
        Point enemyThree = new Point(2459*drawingThread.displayY/1080, 74*drawingThread.displayY/1080);
        Point enemyFour = new Point(2459*drawingThread.displayY/1080, 456*drawingThread.displayY/1080);
        Point enemyFive = new Point(2459*drawingThread.displayY/1080, 778*drawingThread.displayY/1080);
        Point enemySix = new Point(2952*drawingThread.displayY/1080, 241*drawingThread.displayY/1080);
        Point enemySeven = new Point(2952*drawingThread.displayY/1080, 623*drawingThread.displayY/1080);
        Point enemyEight = new Point(3436*drawingThread.displayY/1080, 74*drawingThread.displayY/1080);
        Point enemyNine = new Point(3587*drawingThread.displayY/1080, 462*drawingThread.displayY/1080);
        Point enemyTen = new Point(3436*drawingThread.displayY/1080, 778*drawingThread.displayY/1080);
        Point enemyEleven = new Point(4368*drawingThread.displayY/1080, 456*drawingThread.displayY/1080);

        Point weaponOne = new Point(1163*drawingThread.displayY/1080, 631*drawingThread.displayY/1080);
        Point weaponTwo = new Point(1723*drawingThread.displayY/1080, 187*drawingThread.displayY/1080);
        Point weaponThree = new Point(2171*drawingThread.displayY/1080, 507*drawingThread.displayY/1080);
        Point weaponFour = new Point(3371*drawingThread.displayY/1080, 623*drawingThread.displayY/1080);

        enemy1=new EnemyStageTwo(drawingThread, enemyOne);
        enemy2=new EnemyStageTwo(drawingThread, enemyTwo);
        enemy3=new EnemyStageTwo(drawingThread, enemyThree);
        enemy4=new EnemyStageTwo(drawingThread, enemyFour);
        enemy5=new EnemyStageTwo(drawingThread, enemyFive);
        enemy6=new EnemyStageTwo(drawingThread, enemySix);
        enemy7=new EnemyStageTwo(drawingThread, enemySeven);
        enemy8=new EnemyStageTwo(drawingThread, enemyEight);
        enemy9=new EnemyStageTwo(drawingThread, enemyNine);
        enemy10=new EnemyStageTwo(drawingThread, enemyTen);
        enemy11=new EnemyStageTwo(drawingThread, enemyEleven);

        weapon1=new WeaponStageTwo(drawingThread, weaponOne);
        weapon2=new WeaponStageTwo(drawingThread, weaponTwo);
        weapon3=new WeaponStageTwo(drawingThread, weaponThree);
        weapon4=new WeaponStageTwo(drawingThread, weaponFour);

    }

    public void fire(Point p){

        if(p.x>=(1189*drawingThread.displayY)/1080 && p.x<=(1578*drawingThread.displayY)/1080  &&  p.y>=(150*drawingThread.displayY)/1080 && p.y<=(306*drawingThread.displayY)/1080){
            enemy1.fireCount+=1;
            enemy1.isDead();
        }else if(p.x>=(1189*drawingThread.displayY)/1080 && p.x<=(1578*drawingThread.displayY)/1080  &&  p.y>=(694*drawingThread.displayY)/1080 && p.y<=(850*drawingThread.displayY)/1080){
            enemy2.fireCount+=1;
            enemy2.isDead();
        }else if(p.x>=(2119*drawingThread.displayY)/1080 && p.x<=(2508*drawingThread.displayY)/1080  &&  p.y>=(67*drawingThread.displayY)/1080 && p.y<=(223*drawingThread.displayY)/1080){
            enemy3.fireCount+=1;
            enemy3.isDead();
        }else if(p.x>=(2119*drawingThread.displayY)/1080 && p.x<=(2508*drawingThread.displayY)/1080  &&  p.y>=(462*drawingThread.displayY)/1080 && p.y<=(618*drawingThread.displayY)/1080){
            enemy4.fireCount+=1;
            enemy4.isDead();
        }else if(p.x>=(2119*drawingThread.displayY)/1080 && p.x<=(2508*drawingThread.displayY)/1080  &&  p.y>=(789*drawingThread.displayY)/1080 && p.y<=(945*drawingThread.displayY)/1080){
            enemy5.fireCount+=1;
            enemy5.isDead();
        }else if(p.x>=(2642*drawingThread.displayY)/1080 && p.x<=(3031*drawingThread.displayY)/1080  &&  p.y>=(246*drawingThread.displayY)/1080 && p.y<=(402*drawingThread.displayY)/1080){
            enemy6.fireCount+=1;
            enemy6.isDead();
        }else if(p.x>=(2636*drawingThread.displayY)/1080 && p.x<=(3025*drawingThread.displayY)/1080  &&  p.y>=(636*drawingThread.displayY)/1080 && p.y<=(792*drawingThread.displayY)/1080){
            enemy7.fireCount+=1;
            enemy7.isDead();
        }else if(p.x>=(4110*drawingThread.displayY)/1080 && p.x<=(4499*drawingThread.displayY)/1080  &&  p.y>=(463*drawingThread.displayY)/1080 && p.y<=(715*drawingThread.displayY)/1080){
            enemy11.fireCount+=1;
            enemy11.isDead();
        }else if(p.x>=(3102*drawingThread.displayY)/1080 && p.x<=(3491*drawingThread.displayY)/1080  &&  p.y>=(784*drawingThread.displayY)/1080 && p.y<=(940*drawingThread.displayY)/1080){
            enemy10.fireCount+=1;
            enemy10.isDead();
        }
        if(p.x>=(3119*drawingThread.displayY)/1080 && p.x<=(3508*drawingThread.displayY)/1080  &&  p.y>=(72*drawingThread.displayY)/1080 && p.y<=(228*drawingThread.displayY)/1080){
            enemy8.fireCount+=3;

            enemy8.isDead();
        }
        if(p.x>=(3269*drawingThread.displayY)/1080 && p.x<=(3658*drawingThread.displayY)/1080  &&  p.y>=(462*drawingThread.displayY)/1080 && p.y<=(618*drawingThread.displayY)/1080){
            enemy9.fireCount+=3;

            enemy9.isDead();
        }
    }

    public void fireUp(Point p){

    }

    public void fireDown(Point p){

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

            b12.x-=val;
            b34.x-=val;
            b45.x-=val;
            b67.x-=val;
            b89.x-=val;
            b910.x-=val;
            b36.x-=val;
            b57.x-=val;
            b68.x-=val;
            b710.x-=val;
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

            b12.x+=val;
            b34.x+=val;
            b45.x+=val;
            b67.x+=val;
            b89.x+=val;
            b910.x+=val;
            b36.x+=val;
            b57.x+=val;
            b68.x+=val;
            b710.x+=val;
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




        if(y<=35 || y>=1241) return false;
        else if(x<=78 || x>=5724) return false;
        else if(x>=0 && y>=0 && x<=702 && y<=192) return false;
        else if(x>=0 && y>=0 && x<=549 && y<=324) return false;
        else if(x>=0 && y>=0 && x<=316 && y<=493) return false;
        else if(x>=0 && y>=456 && x<=435 && y<=778) return false;
        else if(x>=1230 && y>=0 && x<=2082 && y<=143) return false;
        else if(x>=1187 && y>=875 && x<=2039 && y<=1080) return false;
        else if(x>=930 && y>=919 && x<=2296 && y<=1080) return false;
        else if(x>=4154 && y>=0 && x<=5760 && y<=192) return false;
        else if(x>=4368 && y>=0 && x<=5760 && y<=304) return false;
        else if(x>=4625 && y>=0 && x<=5760 && y<=366) return false;
        else {
            return true;
        }
    }
}
