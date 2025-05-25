package practice.Threads.observerPattern;

public class SharedResource {

    boolean itemsAvailable = false;

    // observable
    synchronized void addItem() {
        System.out.println("Inside Add item : "+Thread.currentThread().getName());
        itemsAvailable = true;
        notifyAll();
    }


    // observer
    synchronized void consumeItems() {
        try {
            System.out.println("Inside ConsumeItem :  " + Thread.currentThread().getName());
            // while is used to continously check again if there is "Spurious wake up"
            while (!itemsAvailable) {
                System.out.println("no item available so wait : "+ Thread.currentThread().getName());
                wait();// monitor lock is released and other thread can run add item
            }
            System.out.println("item available for "  + Thread.currentThread().getName());
            itemsAvailable = false;
        } catch (Exception e) {

        }
    }
}
