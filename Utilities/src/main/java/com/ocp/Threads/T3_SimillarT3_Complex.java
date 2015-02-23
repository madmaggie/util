package com.ocp.Threads;

/**
 * Created by Rox on 23.02.2015.
 */
public class T3_SimillarT3_Complex extends Thread {
    StringBuilder innerObj;      // Q: how do you get 3 objects to point to the same 4-th object?`

    public T3_SimillarT3_Complex(StringBuilder givenObj) {
        innerObj = givenObj;
    }

    public void run() {
        // synchronised block will get a lock on the givenObj
        // synchronized (innerObj) {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Referanced obj is: " + innerObj.toString());
        }
        innerObj.append(innerObj.charAt(0));
        //   }`
    }

    public static void main(String[] args) {
        StringBuilder givenObj = new StringBuilder("A");
        T3_SimillarT3_Complex first = new T3_SimillarT3_Complex(givenObj);
        T3_SimillarT3_Complex second = new T3_SimillarT3_Complex(givenObj);
        T3_SimillarT3_Complex third = new T3_SimillarT3_Complex(givenObj);
        first.start();
        second.start();
        third.start();
    }
}