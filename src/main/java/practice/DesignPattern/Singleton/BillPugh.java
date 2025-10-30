package practice.DesignPattern.Singleton;
//BILL PUGH solution
// locking is slow
// eager is good in that sense
// but eager with inner class

public class BillPugh {
    private BillPugh(){};
    private static class BillPughHelper {
        private static final BillPugh instance = new BillPugh();
    }
    // only set when called best
    public static BillPugh getInstance() {
        return BillPughHelper.instance;
    }

}
