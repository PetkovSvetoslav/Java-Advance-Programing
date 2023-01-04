package Lab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> ints = new Jar<>();
        ints.add(12);
        System.out.println(ints.remove());

        Jar<String> strings = new Jar<>();
        strings.add("Demo");
        System.out.println(strings.remove());
    }
}
