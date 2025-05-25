package practice.Threads.observerPattern;

public class Main {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();
        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(10000);
                obj.addItem();
            }catch (Exception e) {

            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            obj.consumeItems();
        }, "t2");
        Thread t3 = new Thread(() -> {
            obj.consumeItems();
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
