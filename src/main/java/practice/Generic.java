package practice;

public class Generic <K,V>{

    private K key;
    private V value;

    public void print (K key, V value) {
        System.out.println(key.toString() + " --> " + value.toString());
    }
}
