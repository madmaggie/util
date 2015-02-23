package com.ocp.Threads;

/**
 * Created by Rox on 22.02.2015.
 */
public class T3_MainThread implements Runnable {

    int x;
    public void run(){
        x = 5;
    }

    public static void main(String[] args) {
        T3_MainThread tc = new T3_MainThread();
        tc.x = 10;
        new Thread(tc).start(); // 1
        System.out.println(tc.x); //   
    }
}
