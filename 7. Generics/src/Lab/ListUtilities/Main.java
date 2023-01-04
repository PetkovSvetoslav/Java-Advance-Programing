package Lab.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "credit", "buds", "people");
        String max = ListUtils.getMax(stringList);
        System.out.println(max);

        List<Character> characterList = new ArrayList<>();
        Collections.addAll(characterList, 'a', 'u', '-', '1');
        Character min = ListUtils.getMin(characterList);
        System.out.println(min);
    }
}
