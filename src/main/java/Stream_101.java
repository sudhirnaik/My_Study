import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import practice.Threads.EvenOdd;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream_101 {

  public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, InvocationTargetException {
       /* List<String> list = Arrays.asList("Heelo", "World","I","Am","Sudhir");
        Object u;
        System.out.println(list.stream().filter((test) -> test.length()>3)
                .mapToInt((t) -> t.length()).sum());*/

        //This example read a text file, split the line by spaces, and displayed the total number of the words.

        Path path = Paths.get("F:\\Study\\My_study\\src\\main\\java\\test\\test.txt");

         Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

      //System.out.println(lines.flatMap(x -> Arrays.stream(x.split(" "))).count());

      String[] strArr = {"Test", "Test12345", "hello"};

      Predicate<String > p = (String t) -> {
          if(t.length()>5) {
              return true;
          } else{
              return false;
          }
      };

      System.out.println(Arrays.stream(strArr).count());

        Stream.of(strArr).filter((t) -> t.length()>5).forEach(System.out::println);

    }


}


