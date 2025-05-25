package practice.Threads.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        SharedResource sr1 = new SharedResource(lock);
        SharedResource sr2 = new SharedResource(lock);

// resourse objects are different , but still only one thread can enter a method. with syn it has to same objects(lMonitor lock on object)
        Thread t1 = new Thread(() -> {
            sr1.method1();
        });
        Thread t2 = new Thread(() -> {
            sr2.method2();
        });
        t1.start();
        t2.start();
    }
}
