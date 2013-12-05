package pl.grzeslowski.binary_search_kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursiveBinarySearch<T extends Comparable<T>> implements
        BinarySearchArray<T> {

    private final List<T> array = new ArrayList<>();

    @Override
    public void add(final T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        int add = 0;
        for (final Iterator<T> it = array.iterator(); it.hasNext();) {
            final T next = it.next();

            final int compareTo = next.compareTo(element);
            if (compareTo > 0) {
                break;
            } else if (compareTo == 0) {
                throw new IllegalArgumentException(
                        "Cannot add twice the same element!");
            } else {
                add++;
            }
        }

        array.add(add, element);
    }

    @Override
    public boolean remove(final T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        for (final Iterator<T> it = array.iterator(); it.hasNext();) {
            final T next = it.next();
            if (element.equals(next)) {
                it.remove();
                return true;
            } else if (next.compareTo(element) > 0) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean contains(final T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        for (final T t : array) {
            if (element.equals(t)) {
                return true;
            } else if (t.compareTo(element) > 0)
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public int findIndex(final T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        final int findIndex = findIndex(element, array, 0);
        if (findIndex >= 0) {
            return findIndex;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int findIndex(final T element, final List<T> split,
            final int firstIndex) {
        if (element == null) {
            throw new NullPointerException();
        }

        final int size = split.size();
        if (size == 1) {
            final T t = split.get(0);
            if (t.compareTo(element) == 0) {
                return firstIndex;
            } else {
                return -1;
            }
        } else if (size == 0) {
            return -1;
        } else {
            final int half = size / 2;
            final List<T> left = split.subList(0, half);
            final List<T> right = split.subList(half, size);

            final int findIndexLeft = findIndex(element, left, firstIndex);
            final int findIndexRight = findIndex(element, right, half
                    + firstIndex);

            return findIndexLeft != -1 ? findIndexLeft : findIndexRight;
        }
    }

}
