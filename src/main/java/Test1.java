import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class Test1 {

    int count = 10;

    volatile int globalnum = 1;

    synchronized public void print1() throws InterruptedException {
        while(globalnum <= count) {
            if (globalnum % 3 == 1) {
                System.out.println(Thread.currentThread().getName() + " : " +globalnum++);
                notifyAll();
            } else {
                wait();
            }
        }
    }

    synchronized public void print2() throws InterruptedException {
        while(globalnum <= count) {
            if (globalnum % 3 == 2) {
                System.out.println(Thread.currentThread().getName() + " : " +globalnum++);
                notifyAll();
            } else {
                wait();
            }
        }
    }

    synchronized public void print3() throws InterruptedException {
        while(globalnum <= count) {
            if (globalnum % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " +globalnum++);
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        Thread t1 = new Thread(()->{
            try {
                test.print1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread -1");

        Thread t2 = new Thread(()->{
            try {
                test.print2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread -2");

        Thread t3 = new Thread(()->{
            try {
                test.print3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread -3");

        t1.start();
        t2.start();
        t3.start();
    }


}
