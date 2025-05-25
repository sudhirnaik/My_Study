public class Child extends  Parent {
    Child () {
        this ("Constructor");
        System.out.println("child class defualt constructor");
    }
    
    Child(String s) {
        super(s);

        System.out.println("child class param " + s);
    }

    public static void main(String[] args) {
        Child child = new Child();
    }

}
