import java.util.Arrays;
import java.util.Comparator;

/*
@postmapping
v1/api/books
{}

@getMapping
//get all books
v1/api/books

@getMapping
//get specifoc boo
v1/api/books/{book_id}
v1/api/books?book_id=1


@PUTMapping
//update
v1/api/books
{
}







*/
class Person implements Comparable<Person> {
    int age;

    Enum
    static int b;

    public Person(int age) { this.age = age; }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

public class Test123{


    public static void main(String[] args) {
        Person[] arr = { new Person(30), null,new Person(25) };
        Arrays.sort(arr,Comparator.nullsLast(Comparator.reverseOrder()));
        for (Person p1: arr
             ) {
            System.out.println(p1);
        }


    }

}
