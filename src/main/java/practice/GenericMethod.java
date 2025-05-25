package practice;

public class GenericMethod {
    public <T> String concat(T val) {
        String str  = val.toString()+ "test";
        return str;
    }
}
