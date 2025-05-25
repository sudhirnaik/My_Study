package practice.Threads;

/*
Write a Java program to print a sequence of numbers up to N using 3 threads.
For example, if we want to print a sequence of numbers up to 10 then it’ll look like this:

THREAD-1 : 1
THREAD-2 : 2
THREAD-3 : 3
THREAD-1 : 4
THREAD-2 : 5
THREAD-3 : 6
THREAD-1 : 7
THREAD-2 : 8
THREAD-3 : 9
THREAD-1 : 10
 */

public class ThreeThreadNumber{

    int count = 10;

    volatile int val = 1;

    synchronized void print1stThread() throws Exception{
        for (; val<= count;) {
            if (val%3==1)  {
                System.out.println(Thread.currentThread().getName() + " : "+val);
                val++;
                notifyAll();
            } else {
                while (val<=count && val%3!=1) {
                   /* if (val==count) {
                        Thread.currentThread().stop();
                    }*/
                    wait();
                }
            }
        }
    }

    synchronized void print2ndThread() throws Exception{
        for (; val<= count; ) {
            if (val%3==2)  {
                System.out.println(Thread.currentThread().getName() + " : "+val);
                val++;
                notifyAll();
            } else {
                while (val<=count && val%3!=2) {
                    /*if (val==count) {
                        Thread.currentThread().stop();
                    }*/
                    wait();
                }
            }
        }
    }

    synchronized void print3rdThread() throws Exception{
        for (; val<= count; ) {
            if (val%3==0)  {
                System.out.println(Thread.currentThread().getName() + " : "+val);
                val++;
                notifyAll();
            } else {
                while (val<=count && val%3!=0) {
                    /*if (val==count) {
                        Thread.currentThread().stop();
                    }*/
                    wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadNumber test = new ThreeThreadNumber();

        Thread t1 = new Thread(() -> {
            try {
                test.print1stThread();
            } catch (Exception e) {
               // e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                test.print2ndThread();
            } catch (Exception e) {
                // e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                test.print3rdThread();
            } catch (Exception e) {
                // e.printStackTrace();
            }
        });

        t1.start();t2.start();t3.start();


    }




}
