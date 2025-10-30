package practice.Threads;

import sun.awt.windows.ThemeReader;

public class ThreeThread_new {

    int count;
    int i = 1;

    public ThreeThread_new(int count) {
        this.count = count;
    }

    public synchronized void print1st() throws InterruptedException {
        while (i<=count) {
            while (i<=count && i%3 != 1){
                wait();
            }
            if (i<=count) {
                System.out.println(Thread.currentThread() + " : " + i);
                i++;
                notifyAll();
            }
        }
    }

    public synchronized void print2nd() throws InterruptedException {
        while (i<=count) {
            while (i<=count && i%3 != 2){
                wait();
            }
            if (i<=count) {
                System.out.println(Thread.currentThread() + " : " + i);
                i++;
                notifyAll();
            }
        }
    }

    public synchronized void print3rd() throws InterruptedException {
        while (i<=count) {
            while (i<=count && i%3 != 0){
                wait();
            }
            if (i<=count) {
                System.out.println(Thread.currentThread() + " : " + i);
                i++;
                notifyAll();
            }
        }
    }

    // rpint 1, 2, 3 using 3 threads
    public static void main(String[] args) {
        ThreeThread_new obj = new ThreeThread_new(10);
        Thread t1 = new Thread(() -> {
            try {
                obj.print1st();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                obj.print2nd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                obj.print3rd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                obj.print3rd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
