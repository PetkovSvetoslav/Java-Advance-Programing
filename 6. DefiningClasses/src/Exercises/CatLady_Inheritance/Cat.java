package Exercises.CatLady_Inheritance;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s"
                , this.getClass().getSimpleName(), this.name);
    }
}
