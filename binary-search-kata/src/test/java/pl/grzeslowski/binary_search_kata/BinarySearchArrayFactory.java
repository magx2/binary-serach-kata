package pl.grzeslowski.binary_search_kata;

final class BinarySearchArrayFactory {

    public BinarySearchArray<Object> newBinarySearchArray(final Class<?> clazz) {
        if (clazz == FunctionalBinarySearch.class) {
            return new FunctionalBinarySearch<>();
        } else if (clazz == IterativeBinarySearch.class) {
            return new IterativeBinarySearch<>();
        } else if (clazz == RecursiveBinarySearch.class) {
            return new RecursiveBinarySearch<>();
        } else {
            throw new IllegalArgumentException("I don't know this class: {"
                    + clazz.getSimpleName() + "}!");
        }
    }
}
