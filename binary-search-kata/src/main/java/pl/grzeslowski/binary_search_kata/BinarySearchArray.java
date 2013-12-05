package pl.grzeslowski.binary_search_kata;

public interface BinarySearchArray<T> {

    /**
     * Add elements to BinarySearchArray.
     * 
     * @param element
     *            element to be added.
     */
    void add(final T element);

    /**
     * Removes element from BinarySearchArray.
     * 
     * @param element
     *            element to remove.
     * @return true if element was in array and it was removed, false otherwise.
     */
    boolean remove(final T element);

    /**
     * Check it BinarySearchArray contains element.
     * 
     * @param element
     *            element to check if it's in.
     * @return true if element is in array, false otherwise.
     */
    boolean contains(final T element);

    /**
     * Finding index of given element.
     * 
     * @param element
     *            element to check index.
     * @throws IllegalArgumentException
     *             if element is not in BinarySearchArray.
     * @return index of element.
     */
    int findIndex(final T element);
}
