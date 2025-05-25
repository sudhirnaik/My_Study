package practice.Threads.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    ReentrantLock lock;

    public SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }

    public void method1() {
        try {
            lock.lock();
            System.out.println("inside method 1: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("finish method 1: " + Thread.currentThread().getName());
            lock.unlock();
        } catch (Exception e) {

        }
    }

    public void method2() {
        try {
            lock.lock();
            System.out.println("inside method 2: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            lock.unlock();
        }catch (Exception e) {

        }
    }
}
