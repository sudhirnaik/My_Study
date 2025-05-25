package practice.Threads;

public class MonitorLockExample {

    public synchronized void task1() {
        try {
            System.out.println("inside Task 1");
            Thread.sleep(1000);
            System.out.println("completed Task 1");
        }catch (Exception e){
            // do nothing
        }
    }

    public void task2() {
        System.out.println("task 2, before synchronised");
        synchronized (this) {
            System.out.println("task 2, after synchronised");
        }
    }

    public void task3 () {
        System.out.println("task 3");
    }

    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread t1 = new Thread(() -> {obj.task1();});
        Thread t2 = new Thread(() -> obj.task2());
        Thread t3 = new Thread (() -> obj.task3());
        t1.start();
        t2.start();
        t3.start();
    }
}
