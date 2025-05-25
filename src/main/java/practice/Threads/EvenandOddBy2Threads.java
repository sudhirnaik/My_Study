package practice.Threads;

public class EvenandOddBy2Threads implements Runnable {
    static int count =1;
    Object obj;

    public EvenandOddBy2Threads(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (count <=10) {
            if (count%2==0 && Thread.currentThread().getName().equals("even")){
                synchronized (obj) {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + ", value = " + count);
                    count++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (count%2!=0 && Thread.currentThread().getName().equals("odd")){
                synchronized (obj) {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + ", value = " + count);
                    count++;
                    obj.notify();
                }
            }
        }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        EvenandOddBy2Threads r1 = new EvenandOddBy2Threads(lock);
       // EvenandOddBy2Threads r2 = new EvenandOddBy2Threads(lock);
        Thread t1 = new Thread(r1, "even");
        Thread t2 = new Thread(r1, "odd");
        t1.start();t2.start();

    }
}
