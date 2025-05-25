package practice.FailFast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
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
        System.out.println("Start : "+list);

// The iterator's expected ModCount is set to the list's current modCount here
        try {
            while (iterator.hasNext()) {
                String element = iterator.next();
                if (element.equals("B")) {
                    // Structural modification outside of iterator, modCount is updated
                    list.remove("C");

                    // Now, when next() or hasNext() is called, modCount != expectedModCount
                }
            }
        } catch (Exception e){
            System.out.println(list);
        }

        System.out.println(list);
    }
}
