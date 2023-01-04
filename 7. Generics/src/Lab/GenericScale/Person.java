package Lab.GenericScale;

public class Person implements Comparable<Person> {
    private int weight;

    public Person(int weight) {
        this.weight = weight;
    }

    public int compareTo(Person other) {
        return Integer.compare(this.weight, other.weight);
    }
}
