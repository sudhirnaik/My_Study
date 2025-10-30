import java.util.Arrays;
import java.util.List;

public class Stream_101 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Heelo", "World","I","Am","Sudhir");
        Object u;
        System.out.println(list.stream().filter((test) -> test.length()>3)
                .mapToInt((t) -> t.length()).sum());
    }
}
