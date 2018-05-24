package game.javaproject.escape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {

    static class Pair{
        int a,b;
        public Pair(int a, int b){
            this.a=a;
            this.b=b;
        }

        public int getValue(){
            return this.b;
        }

        public int getKey(){
            return this.a;
        }
    }

    static int idx;

    static int[] dX = { -1, -1, -1, +1, +1, +1, 0, 0 };
    static int[] dY = { -1, 0, +1, -1, 0, +1, -1, +1 };
    static Pair[] path = new Pair[7000];
    //static Pair[][] par = new Pair[5800][1100];
    static Map<Pair, Pair> par = new HashMap<>();


   static boolean[][] vis;

    static void go(int x1, int y1, int x2, int y2) {
         vis = new boolean[5800][1100];
        for(int i=0;i<5800;i++)
            for(int j=0;j<1100;j++)
                vis[i][j]=false;
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(x1, y1);
        q.add(p);
        vis[x1][y1]=true;
        while (!q.isEmpty()) {
            System.out.println(q.size());
            boolean B = false;
            Pair cur = q.remove();
            for (int i = 0; i < 8; i++) {
                int x = (int) cur.getKey() + dX[i];
                int y = (int) cur.getValue() + dY[i];
                if (is_ok(x, y)) {
                    vis[x][y]=true;
                    Pair newp = new Pair(x, y);
                    par.put(newp ,cur);
                    q.add(newp);
                }

                if (x == x2 && y == y2)
                    B=true;
            }
            if(B)
                break;

        }
        Pair now = new Pair(x2, y2);
        Pair des = new Pair(x1, y1);
        idx = 0;
        while (true) {
            path[idx] = now;
            //System.out.println(now);
            idx++;
            //System.out.println(idx);
            now = par.get(now);
            if ((int) now.getKey() == x1 && (int) now.getValue()==y1)
            {
                //System.out.println("found");
                break;
            }
        }
        printPath(idx);
    }

    static void printPath(int idx) {
        for (int i = idx-1; i >= 0; i--) {
            //System.out.println(i);
            Pair c = path[i];
            int x = (int) c.getKey();
            int y= (int) c.getValue();
            System.out.println(x +" " + y);
        }
    }

    static boolean is_ok(int x, int y) {
        if (vis[x][y])
            return false;
        if (x >= 1090 && x <= 1730 && y >= 130 && y <= 210)
            return false;
        else if (x >= 810 && x <= 1660 && y >= 280 && y <= 360)
            return false;
        else if (x >= 3650 && x <= 3940 && y >= 400 && y <= 480)
            return false;
        else if (x >= 3420 && x <= 3870 && y >= 520 && y <= 600)
            return false;
        else if (x >= 3420 && x <= 3520 && y >= 300 && y <= 520)
            return false;
        else if (x >= 3050 && x <= 3250 && y >= 420 && y <= 704)
            return false;
        else if (x >= 1880 && x <= 2620 && y >= 280 && y <= 620)
            return false;
        else if (x >= 1500 && x <= 3150 && y >= 420 && y <= 500)
            return false;
        else if (x >= 1470 && x <= 2920 && y >= 2500 && y <= 620)
            return false;
        else if (x >= 1650 && x <= 1900 && y >= 270 && y <= 320)
            return false;
        else if (x >= 1800 && x <= 1960 && y >= 320 && y <= 360)
            return false;
        else if (x >= 710 && x <= 910 && y >= 420 && y <= 520)
            return false;
        else if (x >= 670 && x <= 850 && y >= 490 && y <= 610)
            return false;
        else if (x >= 640 && x <= 820 && y >= 560 && y <= 690)
            return false;
        else if (x >= 570 && x <= 770 && y >= 680 && y <= 810)
            return false;
        else if (x >= 1020 && x <= 1390 && y >= 420 && y <= 610)
            return false;
        else if (x >= 960 && x <= 1190 && y >= 590 && y <= 720)
            return false;
        else if (x >= 3940 && x <= 4560 && y >= 400 && y <= 700)
            return false;
        else if (x >= 460 && x <= 1040 && y <= 210)
            return false;
        else if (x >= 1040 && x <= 1800 && y <= 90)
            return false;
        else if (x >= 1800 && x <= 5140 && y <= 210)
            return false;
        else if (x >= 900 && y >= 700 && y <= 800)
            return false;
        else if (x >= 2800 && y >= 270 && y <= 360)
            return false;
        else if (x >= 5140 && y <= 800)
            return false;
        else if (x <= 460)
            return false;
        else if (y >= 890)
            return false;
        else if (x >= 5480)
            return false;
        else
            return true;
    }
}
