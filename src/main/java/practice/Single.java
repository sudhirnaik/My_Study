package practice;

public class Single {
    private static Single single;

    private Single(){

    }

    static Single getInstance() {
        if (single == null){

            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}
