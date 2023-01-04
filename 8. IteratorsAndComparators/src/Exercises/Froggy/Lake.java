package Exercises.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private class StonesIterator implements Iterator<Integer> {
        private int index = 0;
        private final int lastEvenIndex = stones.length % 2 == 0 ? stones.length - 2 : stones.length - 1;

        @Override
        public boolean hasNext() {
            return this.index < stones.length;
        }

        @Override
        public Integer next() {
            int element = stones[this.index];
            if (this.index == this.lastEvenIndex) {
                this.index = 1;
            } else {
                this.index += 2;
            }
            return element;
        }
    }

    private final int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    public Iterator<Integer> iterator() {
        return new StonesIterator();
    }
}
