import java.lang.reflect.Array;

public class CustomList<T extends Comparable<T>> {


    private T[] elements;
    private int size;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public CustomList(Class<T> clazz) {
        this.elements = (T[]) Array.newInstance(clazz, 8);
        this.clazz = clazz;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (this.elements.length == this.size) {
            T[] newElements = (T[]) Array.newInstance(clazz, this.size * 2);

            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }

            this.elements = newElements;
        }
        this.elements[this.size++] = element;
    }

    public T get(int index) {
        validateIndex(index);
        return this.elements[index];
    }


    public void set(int index, T element) {
        validateIndex(index);

        this.elements[index] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        validateIndex(index);

        T element = this.elements[index];


        for (int i = 0; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[--this.size] = null;

        if (this.elements.length == this.size * 4 && this.size >= 8) {
            T[] newElements = (T[]) Array.newInstance(elements.getClass(), this.size);

            System.arraycopy(this.elements, 0,
                    newElements, 0, newElements.length);

            this.elements = newElements;
        }
        return element;
    }

    public boolean contains(T element) {
        for (T e : this.elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.elements[firstIndex];
        T secondElement = this.elements[secondIndex];

        set(firstIndex, secondElement);
        set(secondIndex, firstElement);
    }

    private void validateIndex(int index) {
        if (0 > index || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int countGreaterThan(T toCompare) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].compareTo(toCompare) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T maxElement = this.elements[0];
        for (int i = 1; i < this.size; i++) {
            if(maxElement.compareTo(this.elements[i]) < 0){
                maxElement = this.elements[i];
            }
        }
        return maxElement;
    }

    public T getMin() {
        T minElement = this.elements[0];
        for (int i = 1; i < this.size; i++) {
            if (minElement.compareTo(this.elements[i]) > 0){
                minElement = this.elements[i];
            }
        }
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.elements[i]).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    //void add (T element) - DONE
    //T remove (int index) - DONE
    //boolean contains(T element) - DONE
    //void swap(int index, int index) - DONE
    //int countGreaterThan(T element) - DONE
    //T getMax() - DONE
    //T getMin() - DONE
}

