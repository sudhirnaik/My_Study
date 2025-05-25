package practice.Threads;

public class EvenOdd {

    int count;

    volatile int globalCount = 1;

    public EvenOdd(int count) {
        this.count = count;
    }



    public synchronized void printEven() throws Exception{
        while(globalCount <= count) {
            if (globalCount%2==0) {
                System.out.println("even : "+globalCount );
                System.out.println("Thread : "+ Thread.currentThread().getName());
                notifyAll();
                globalCount++;
            } else {
                wait();
            }
        }
    }

    // first satrt odd
    public synchronized void printOdd() throws Exception {
        while(globalCount <= count) {
            if (globalCount%2!=0) {
                System.out.println("odd : "+globalCount);
                System.out.println("Thread : "+ Thread.currentThread().getName());
                notifyAll();
                globalCount++;
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd(10);

        Thread evenThread = new Thread(()-> {
            try{
                Thread.sleep(10000);
                evenOdd.printEven();
            } catch (InterruptedException e) {
                //
            } catch (Exception e) {
                //e.printStackTrace();
            }

        }, "even");

        Thread oddThread = new Thread(()-> {
            try{
                evenOdd.printOdd();
            } catch (Exception e) {
                //e.printStackTrace();
            }

        }, "odd");

        evenThread.start();
        oddThread.start();

    }
}
