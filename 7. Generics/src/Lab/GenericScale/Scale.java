package Lab.GenericScale;

public class Scale<E extends Comparable<E>> {
    private E first;
    private E second;

    public Scale(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getHeavier() {
        int result = this.first.compareTo(this.second);
        if (result > 0) {
            return this.first;
        } else if (result < 0) {
            return this.second;
        } else {
            return null;
        }
    }
}
