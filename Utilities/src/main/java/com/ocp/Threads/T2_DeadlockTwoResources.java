package com.ocp.Threads;

/**
 * Created by Rox on 22.02.2015.
 */

public class T2_DeadlockTwoResources {

    Object a = new Object();
    Object b = new Object();


    /*
        Daca le lasi inversate astepti 2 obiecte
            - Thread1 asteapta objB
            - Thread2 asteapta objA

        E posibil sa nu fie problema sau e posibil sa se intercaleze.
        Dar daca pui amandoua thread-urile sa astepte acelasi obiect
        sigur n-o sa se blocheze.

     */
    public void getLocks(Object a, Object b) {
        synchronized (a) {
            synchronized (b) {
                System.out.println(" Thread out");
            }
        }
    }

    class Thread1 implements Runnable {
        public void run() {
            getLocks(a, b);
        }
    }

    class Thread2 implements Runnable {
        public void run() {
            getLocks(b, a);
        }
    }

    public void runThisAlready() {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        new Thread(t1).start();
        new Thread(t2).start();
    }

}
