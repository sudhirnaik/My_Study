public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Test");
        System.out.println("Test2");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
    }
}
