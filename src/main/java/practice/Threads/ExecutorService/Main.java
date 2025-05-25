package practice.Threads.ExecutorService;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.sound.midi.Soundbank;
import java.util.concurrent.*;

public class Main {
    //min size 2, max 4, queie contain 2
    // life is 5 mis

    // ThreadFactory is an interface so either write customFactory, or Executers.DefualtFactory()
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                4,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new CustomFactory(),
                new CustomRejectHandler()
        );
        // keep alive is used only when allowcore timeout is true
        executor.allowCoreThreadTimeOut(true);
        // when task is 4 . 2 will be in thread and other 2 will be in queue
        // when task is 5 . the last extra one will create a thread for iys own so total 3 threads
        // when 7 ll 4 threads are full and 2 queue is also full, so 1 will be rejected

        /*for (int i = 1; i <= 7; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    // exception handle
                }
                System.out.println("Thread is processed : " + Thread.currentThread().getName() + " item : " + finalI);
            });
        }*/

        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("done");
            } catch (Exception e) {

            }
        });

        if (!future.isDone()) {
            System.out.println("Still running");
        }

        //future.get();

        System.out.println("done in main");

        executor.shutdown();
    }
}

class CustomFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setDaemon(false);
        th.setPriority(10);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task is  rejected : "+r.toString());
    }
}
