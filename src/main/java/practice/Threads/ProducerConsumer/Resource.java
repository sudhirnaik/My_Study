package practice.Threads.ProducerConsumer;

import java.util.Arrays;
import java.util.Queue;

public class Resource {
    public static final Integer SIZE = 2;
    Queue<Integer> queue = (Queue<Integer>) Arrays.asList(new Integer[SIZE]);

    public synchronized void produce(Integer i) {
        // Queue is full

        while (!queue.offer(i)) {
            try {
                System.out.println("cannot add its full");
                wait();
            }catch (Exception e ){
                // do something
            }
        }
        System.out.println("data added " + i);
        queue.offer(i);
        notifyAll();
    }

    public synchronized Integer consume(){
        while (queue.isEmpty()){
            try {
                System.out.println("cannot sonsume not data so waiting");
                wait();
            } catch (Exception e) {
                //test
            }
        }

        Integer i =  queue.poll();
        System.out.println("data consumed : "+ i);
        notifyAll();
        return i;
    }
}
