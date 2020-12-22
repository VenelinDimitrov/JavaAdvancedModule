package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.elements, index1, index2);
    }

    public int countGreaterThan(T element) {
        int counter = 0;

        for (T t : elements) {
            if (t.compareTo(element) > 0) {
                counter++;
            }
        }

        return counter;
    }

    public T getMax() {
        return Collections.max(this.elements);
    }

    public T getMin() {
        return Collections.min(this.elements);
    }

    public void sort() {
        Collections.sort(this.elements);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (T element : elements) {
            output.append(String.format("%s\n", element));
        }

        return output.toString();
    }
}
