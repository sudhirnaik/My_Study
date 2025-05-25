package practice.Timpass;

public class Eagle implements Bird, LivingThings{
    private String color;

    public Eagle(String color) {
        this.color = color;
    }

    @Override
    public void fly(Integer str) {
        System.out.println(color + " eagle, I am flying at "  + str);
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
