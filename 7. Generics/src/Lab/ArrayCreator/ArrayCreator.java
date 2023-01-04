package Lab.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) Array.newInstance(item.getClass(), length);

        Arrays.fill(array, item);

        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        Arrays.fill(array, item);

        return array;
    }
}
