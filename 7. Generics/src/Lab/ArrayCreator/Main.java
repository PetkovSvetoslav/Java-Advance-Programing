package Lab.ArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] intArr = ArrayCreator.create(10, 9);
        for (Integer integer : intArr) {
            System.out.println(integer);
        }

        System.out.println();

        Character[] charArr = ArrayCreator.create(Character.class, 5, 'q');
        for (Character character : charArr) {
            System.out.println(character);
        }
    }
}
