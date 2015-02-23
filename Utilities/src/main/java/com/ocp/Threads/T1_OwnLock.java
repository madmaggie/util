package com.ocp.Threads;

/**
 * Created by Rox on 22.02.2015.
 */
public class T1_OwnLock implements Runnable {
   int x = 0, y = 0;
   public void run() {
    while(true) {
        synchronized(this) {
            x++; y++;
            System.out.println(" x = "+x+" , y = "+y);
        }
    }
   }

    public static void main(String[] args) {
        T1_OwnLock tc = new T1_OwnLock();
        new Thread(tc).start();
        new Thread(tc).start();
    }
}
