package practice.DesignPattern.Singleton;

public class ThreadSafeLazy {
    // private
    private  static volatile ThreadSafeLazy instance;
    //constructor is private
    private ThreadSafeLazy(){}

    public static ThreadSafeLazy getInstance() {
        //create only when needed
        //synchonized at methid level so many lock
        // lock neede only when creation on new instance by a thread so check it first
        if (instance==null) {
            synchronized (ThreadSafeLazy.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazy();
                }
            }
        }
        return instance;
    }

}
