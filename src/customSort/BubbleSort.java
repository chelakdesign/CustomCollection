package customSort;

import customCollections.CustomArrayList;

import java.util.Comparator;

public class BubbleSort<T> {

    public static <T> void sort(CustomArrayList<T> array) {
        sort(array, null);
    }

    public static <T> void sort(CustomArrayList<T> array, Comparator comparator) {
        boolean isSwap = false;
        int arraySize = array.getSize();

        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                T prev = array.get(j);
                T next = array.get(j + 1);

                if (compare(prev, next, comparator) > 0) {
                    // swap prev and next
                    array.set(j, next);
                    array.set(j + 1, prev);
                    isSwap = true;
                }
            }

            if (isSwap == false) {
                break;
            }
        }
    }

    private static <T> int compare(T first, T second, Comparator comparator) {
        try {
            if (comparator == null) {
                Comparable firstComparable = (Comparable) first;
                return firstComparable.compareTo(second);
            } else {
                return comparator.compare(first, second);
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Not support ordering");
        }
    }
}
