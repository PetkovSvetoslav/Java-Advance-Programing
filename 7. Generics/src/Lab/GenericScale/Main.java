package Lab.GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a", "b");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(12, 9);
        System.out.println(integerScale.getHeavier());
    }
}
