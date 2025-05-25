import com.fasterxml.jackson.databind.ObjectMapper;
import practice.Timpass.Bird;
import practice.Timpass.Eagle;
import practice.Timpass.Student;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        //List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "B", "C"));
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));// concurrentmodification is
        // thrown because there is no hasNext() and so no checkon ModCount
        // modCount is check during hasNext(),Next(), Remove(0
        // hasNext() doent check for concurrent modification
        /*
        public boolean hasNext() {
            return cursor != size();
        }
        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                curs
         */

        Iterator<String> iterator = list.iterator();
        System.out.println("Sart : "+list);

// The iterator's expectedModCount is set to the list's current modCount here
        try {
            while (iterator.hasNext()) {
                String element = iterator.next();
                if (element.equals("B")) {
                    // Structural modification outside of iterator, modCount is updated
                    list.remove("A");

                    // Now, when next() or hasNext() is called, modCount != expectedModCount
                }
            }
        } catch (Exception e){
            System.out.println(list);
        }

        System.out.println(list);

        /*List<String> names = Arrays.asList("test","hello", "world");
        System.out.println("Names: "+names);
        StringBuilder strBuilder= new StringBuilder();
        // first letter caps
        List<String> Names = names.stream().map((s) -> {
            char[] chars = s.toCharArray();
            int c = chars[0]-32;
            chars[0] = (char) c;
            return new String(chars);
        }).collect(Collectors.toList());
        System.out.println("Names: "+Names);

        // longest non repeated sequence
        // abcabcbb
        // 3   // abc

        String input =  "abcabcdf";
        System.out.println("longest num : " +longestNonRepeatedLength(input));





        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 10),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 9),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 8),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 7),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 6),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 5),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 4),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 3),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 2),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 1));


        //1- Find list of students whose first name starts with alphabet A
        List<Student> lstStuName = list.stream().filter(dt -> dt.getFirstName().startsWith("A"))
                .collect(Collectors.toList());

        //2- Group The Student By Department Names

        Map<String, Set<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.toSet()));
        //4- Find the max age of student

        list.stream().mapToInt((s) -> s.getAge()).max();

        //14- Find the list of students and sort them by their rank

        *//*List<Student> stuRankSorted = list.stream().sorted((s1, s2) -> Integer.valueOf(s1.getRank()).compareTo(Integer.valueOf(s2.getRank()))
        ).collect(Collectors.toList());*//*
        *//*List<Student> stuRankSorted = list.stream().sorted(Comparator.comparing(Student::getRank)
        ).collect(Collectors.toList());*//*
*//*
        List<Student> stuRankSorted = list.stream()
                .sorted()
                .collect(Collectors.toList());*//*

       // System.out.println("List of students sorted by their rank  : "+stuRankSorted);

        *//*Map<String, List<Student>> map = list.stream()
                .collect(Collectors.toMap(Student::getDepartmantName));*//*

        System.out.println("Students grouped by the department names : "+map);


        *//*Eagle eg = new Eagle("RED");
        Bird br = new Eagle("Black");

        List<Eagle> egList = new LinkedList<>();
        egList.add(eg);
        List<Bird> brList = new LinkedList<>();
        brList.add(br);
        brList.addAll(egList);

        brList.stream().filter()

        brList.forEach(b -> b.fly(100));

        Bird bird  = (str) -> System.out.println("I am flying functional "+str);
        bird.fly(1000);*/

       /* String[] strs = {"test", "hello","","world"};
        Arrays.stream(strs).map((s) -> {
            String str = "";
            if(!s.isEmpty()) {
                char[] c = s.toCharArray();
                c[0] = Character.toUpperCase(c[0]);
                str = new String(c);
            }
            return str;
        }).forEach(System.out::println);
*/

        //soutNums(3);



    }

    public static void soutNums(int num) {
        if (num == 0) return;
        System.out.println(num);
        soutNums(num - 1);

    }




    private static int longestNonRepeatedLength(String input) {
        if (input.length()<=1) return input.length();
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int right = 1;
        charSet.add(input.charAt(left));
        int MaxCount = 1;
        int count = 1;
        while(right<input.length()) {
            if (!charSet.add(input.charAt(right))){
                count = right-left;
                charSet.clear();
                left = left +1;
                right = left +1;
                charSet.add(input.charAt(left));

            } else {
                count = right - left;
            }

            if (count>MaxCount) {
                MaxCount = count;
            }
            right++;
        }
        return MaxCount;
    }



}




