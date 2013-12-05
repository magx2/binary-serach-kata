package pl.grzeslowski.binary_search_kata;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch<T extends Comparable<T>> implements BinarySearchArray<T> {

    private final List<T> array = new ArrayList<>();

    @Override
    public void add(final T element) {
        array.add(element);
    }

    @Override
    public boolean remove(final T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(final T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int findIndex(final T element) {
        // TODO Auto-generated method stub
        return 0;
    }

}
